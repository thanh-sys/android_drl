package hcm.ptit.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import hcm.ptit.trainingpoint.enitty.EvaluationForm;
import hcm.ptit.trainingpoint.enitty.EvaluationFormOfClassPresident;
import hcm.ptit.trainingpoint.enitty.Semester;
import hcm.ptit.trainingpoint.enitty.Student;
import hcm.ptit.trainingpoint.model.DisciplinaryDecision;
import hcm.ptit.trainingpoint.model.ExamDiscipline;
import hcm.ptit.trainingpoint.model.Status;
import hcm.ptit.trainingpoint.model.dto.SemesterDTO;
import hcm.ptit.trainingpoint.repository.EvaluationFormRepository;
import hcm.ptit.trainingpoint.repository.SemesterRepository;
import hcm.ptit.trainingpoint.repository.StudentRepository;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SemesterService {

    private SemesterRepository semesterRepository;

    private EvaluationFormRepository evaluationFormRepository;

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setEvaluationFormRepository(EvaluationFormRepository evaluationFormRepository) {
        this.evaluationFormRepository = evaluationFormRepository;
    }

    @Autowired
    public void setSemesterRepository(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    public String getDeadline(Integer semesterNo) {
        return findBySemesterNo(semesterNo).get().getDeadline().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Optional<Semester> findBySemesterNo(Integer semesterNo){
        return semesterRepository.findBySemesterNo(semesterNo);
    }

    public ResponseEntity<SemesterDTO> add(SemesterDTO semesterDTO) { //tạo học kì
        Integer semesterNo = semesterDTO.getSemesterNo();
        Optional<Semester> semesterOptional = semesterRepository.findBySemesterNo(semesterNo);
        if (!semesterOptional.isPresent()) {
            //tạo form điền
            // khóa            năm           năm học               học kỳ 1            học kỳ 2             học kỳ hè
            // 62            QH2017         2017-2018                184                  185                 186
            // 1             QH1956         1956-1957                 1                    2                   3
            // n             QH<1956+n-1>   1956+n-1 - 1956+n      3(n-1)+1            3(n-1)+2              3(n-1)+3
            // học kỳ 184 thì SV các khóa sau vẫn còn điền được điểm rèn luyện: K62, 61, 60, 59
            // 184%3= 1 184/3=61  ( học kỳ 1)
            // 185%3= 2 185/3=61  ( học kỳ 2)
            // 186%3= 0 186/3=62  ( học kỳ 3)
            // đặt kỳ học là x
            // nếu x%3!=0 ->học kỳ này có tính điểm rèn luyện
            // các khóa được tạo form đánh giá điểm rèn luyện là: x/3+1, x/3, x/3-1, x/3-2
            if (semesterNo % 3 == 0) { // nếu là học kỳ hè
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            // VD semesterNo= 184
            int x = semesterNo / 3 + 1; // khóa sinh viên năm nhất đang học tại trường 184/3+ 1= 62
            // 1956+62-1= 2017
            List<Student> students = studentRepository.getListStudentCreatedForm((1956 + x - 1)%100,
                    (1956 + x - 2)%100, (1956 + x - 3)%100, (1956 + x - 4)%100); // lần lượt là k62, 61, 60, 59
            // năm vào trường là 2017, 2016, 2015, 2014
            Semester semester = new Semester(semesterNo, semesterDTO.getDeadline()); // lưu học kỳ
            System.out.println("Create semester " + semesterNo + " success! ");
            semesterRepository.save(semester);
            // duyệt list các sinh viên sẽ được tạo phiếu điểm rèn luyện trong kỳ này
            for (Student student : students) {
                EvaluationForm evaluationForm = createEvaluationFormDefault(); // tạo mặc định
                evaluationForm.setStudent(student);
                evaluationForm.setSemester(semester);
                evaluationForm.setStudent(student);
                evaluationFormRepository.save(evaluationForm);// lưu lại
            }

            return new ResponseEntity<>(new SemesterDTO(semesterNo, semesterDTO.getDeadline()), HttpStatus.OK);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<SemesterDTO> addSuccess(SemesterDTO semesterDTO) { //tạo học kì
        Integer semesterNo = semesterDTO.getSemesterNo();
        Optional<Semester> semesterOptional = semesterRepository.findBySemesterNo(semesterNo);
        if (!semesterOptional.isPresent()) {
            if (semesterNo % 3 == 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            int x = semesterNo / 3 + 1;
            List<Student> students = studentRepository.getListStudentCreatedForm((1956 + x - 1)%100,
                    (1956 + x - 2)%100, (1956 + x - 3)%100, (1956 + x - 4)%100);
            // năm vào trường là 2017, 2016, 2015, 2014
            Semester semester = new Semester(semesterNo, semesterDTO.getDeadline());
            System.out.println("Create semester history " + semesterNo + " success! ");
            semesterRepository.save(semester);

            Random random = new Random();
            for (Student student : students) {
                EvaluationForm evaluationForm = createEvaluationFormDefault();
                evaluationForm.setStudent(student);
                evaluationForm.setSemester(semester);
                evaluationForm.setStudent(student);
                evaluationForm.setTotalPoint(random.nextInt(50) + 48);
                evaluationForm.setStatus(Status.SUCCESS);
                evaluationFormRepository.save(evaluationForm);// lưu lại
            }

            return new ResponseEntity<>(new SemesterDTO(semesterNo, semesterDTO.getDeadline()), HttpStatus.OK);
        } else {
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<SemesterDTO> delete(Integer semesterNo) {
        Optional<Semester> semesterOptional = semesterRepository.findBySemesterNo(semesterNo);
        return semesterOptional.map(semester -> {

            //list form SV được tạo trong kỳ semesterNo
            List<EvaluationForm> evaluationForms = evaluationFormRepository.getListBySemester(semesterNo);
            for (EvaluationForm e : evaluationForms) {
                evaluationFormRepository.delete(e);  // xóa các form được tạo ở kỳ đó
            }
            semesterRepository.delete(semester);

            return new ResponseEntity<>(new SemesterDTO(semester.getSemesterNo(), semester.getDeadline()), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private EvaluationForm createEvaluationFormDefault() {
        EvaluationForm e = new EvaluationForm();
        
        
        e.setHoc_luc_yeu(false);
        e.setDi_hoc_dung_gio (false);
        e.setHoc_luc_duoi_trungbinh(false);
        e.setHoc_luc_gioi(false);
        e.setHoc_luc_kha(false);
        e.setHoc_luc_trungbinh(false);
        e.setVuot_kho(false);
//        e.setCanh_cao_hoc_vu(dto.getCanh_cao_hoc_vu());
//        e.setDang_ki_khong_du_tin(dto.getDang_ki_khong_du_tin());
     
        e.setCam_thi_bo_thi(0);
        e.setCanh_cao(0);
        e.setKhien_trach(0);
        e.setDinh_chi(0);
        e.setTham_gia_hoat_dong(0);
//        ExamDiscipline examDiscipline = ExamDiscipline.convertToEnum(dto.getKy_luat_thi());
//        e.setKy_luat_thi(examDiscipline);

        //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
//        e.setNop_nhan_kinh_phi(dto.getNop_nhan_kinh_phi());
//        e.setDang_ki_hoc_qua_han(dto.getDang_ki_hoc_qua_han());
//        e.setKhong_thuc_hien_yeu_cau(dto.getKhong_thuc_hien_yeu_cau());
//        e.setTra_qua_han_giay_to(dto.getTra_qua_han_giay_to());
//        e.setKhong_tham_gia_bao_hiem(dto.getKhong_tham_gia_bao_hiem());
     // private
    	// 2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
     
        e.setKhong_dong_hoc_phi(false);
        e.setVi_pham_quy_dinh_cu_tru(false);
        e.setNghiem_tuc(false);
        e.setKhong_hop_lop(false);
        e.setHoi_thao(false);
        e.setVang_hoi_thao(false);
//        DisciplinaryDecision disciplinaryDecision = DisciplinaryDecision.convertToEnum(dto.getQuyet_dinh_ky_luat());
//        e.setQuyet_dinh_ky_luat(disciplinaryDecision);

        //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
    	
        e.setHien_mau(0);
        e.setTuyen_truyen(0);
        e.setChong_ma_tuy(false);
        e.setSai_lech(false);
       
        e.setTham_gia_chi_doan_chinh_tri(0);
        e.setTham_gia_hoat_dong(0);
//        e.setKhong_tham_gia_sinh_hoat(dto.getKhong_tham_gia_sinh_hoat());
        //4. về phẩm chất công dân và quan hệ với cộng đồng
    
        e.setChap_hanh_luat(false);
        e.setTuyen_truyen_dang(false);
        e.setQuan_he_dung_muc(false);
        e.setQuan_he_dung_tot(false);
        e.setKhen_cong_dong(false);
        e.setVi_pham_an_ninh(false);
       
//        e.setKhong_co_tinh_than_doan_ket(dto.getKhong_co_tinh_than_doan_ket());
        //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
        // được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
      
    	 e.setTham_gia_clb(false);
     
        e.setGiu_chuc_vu(false);
        e.setHoc_luc_gioi_xuat_sac(false);
//        e.setChung_chi_tieng_Anh(dto.getChung_chi_tieng_Anh());
//        e.setTham_gia_cuoc_thi(dto.getTham_gia_cuoc_thi());
//        e.setDat_giai_cuoc_thi(dto.getDat_giai_cuoc_thi());
//        e.setTham_gia_NCKH(dto.getTham_gia_NCKH());
        e.setDat_giai_NCKH(false);
//        e.setKet_nap_Dang(dto.getKet_nap_Dang());
 
//        
//        e.setHoc_luc_yeu(false);
////        e.setCanh_cao_hoc_vu(false);
////        e.setDang_ki_khong_du_tin(false);
//        e.setCam_thi_bo_thi(0);
//        e.setKhien_trach(0);
//        e.setCanh_cao(0);
//        e.setDinh_chi(0);
//        
////        e.setKy_luat_thi(ExamDiscipline.NO);
//
//        //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
////        e.setNop_nhan_kinh_phi(0);
////        e.setDang_ki_hoc_qua_han(false);
////        e.setKhong_thuc_hien_yeu_cau(0);
////        e.setTra_qua_han_giay_to(0);
////        e.setKhong_tham_gia_bao_hiem(false);
//        e.setVi_pham_quy_dinh_cu_tru(false);
////        e.setQuyet_dinh_ky_luat(DisciplinaryDecision.NO);
//
//        //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
//        e.setTham_gia_chi_doan_chinh_tri(0);
//        e.setTham_gia_hoat_dong(0);
//        e.setTuyen_truyen(0);
////        e.setKhong_tham_gia_sinh_hoat(0);
//        //4. về phẩm chất công dân và quan hệ với cộng đồng
//        e.setChap_hanh_luat(false);
////        e.setKhong_co_tinh_than_doan_ket(0);
//
//        //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
//        // được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
//        e.setGiu_chuc_vu(false);
//        e.setHoc_luc_gioi_xuat_sac(false);
////        e.setChung_chi_tieng_Anh(false);
////        e.setTham_gia_cuoc_thi(0);
////        e.setDat_giai_cuoc_thi(false);
////        e.setTham_gia_NCKH(false);
//        e.setDat_giai_NCKH(false);
//        e.setKet_nap_Dang(false);
        e.setEvaluationFormOfClassPresident(null);

        e.setStatus(Status.NEED_STUDENT_FILL);
        e.setTotalPoint(e.autoGenerateTotalPoint());
        return e;
    }


}
