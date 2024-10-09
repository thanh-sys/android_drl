package hcm.ptit.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import hcm.ptit.trainingpoint.enitty.EvaluationForm;
import hcm.ptit.trainingpoint.enitty.EvaluationFormOfClassPresident;
import hcm.ptit.trainingpoint.model.DisciplinaryDecision;
import hcm.ptit.trainingpoint.model.ExamDiscipline;
import hcm.ptit.trainingpoint.model.Status;
import hcm.ptit.trainingpoint.model.dto.EvaluationFormDTO;
import hcm.ptit.trainingpoint.model.dto.InputDTO;
import hcm.ptit.trainingpoint.repository.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluationFormService {

    private EvaluationFormRepository evaluationFormRepository;

    private UserRepository userRepository;

    private StudentRepository studentRepository;

    private SemesterRepository semesterRepository;

    private EvaluationFormOfClassPresidentRepository evaluationFormOfClassPresidentRepository;

    @Autowired
    public void setRepo(EvaluationFormOfClassPresidentRepository repo) {
        this.evaluationFormOfClassPresidentRepository = repo;
    }

    @Autowired
    public void setSemesterRepository(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    public void setEvaluationFormRepository(EvaluationFormRepository evaluationFormRepository) {
        this.evaluationFormRepository = evaluationFormRepository;
    }

    //dynamic query
    public List<EvaluationForm> findByCriteria(InputDTO inputDTO) {
        List<EvaluationForm> evaluationForms = evaluationFormRepository.findAll(new Specification<EvaluationForm>() {
            @Override
            public Predicate toPredicate(Root<EvaluationForm> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();
                if (inputDTO.getName() != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder
                            .like(root.get("student").get("fullName"), "%" + inputDTO.getName() + "%")));
                }
                if (inputDTO.getSemester() != null) {

                    predicates.add(criteriaBuilder.and(criteriaBuilder
                            .equal(root.get("semester").get("semesterNo"), inputDTO.getSemester())
                    ));
                }
                if (inputDTO.getUsername() != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder
                            .like(root.get("student").get("user").get("username"), "%" + inputDTO.getUsername() + "%")
                    ));
                }
                if (inputDTO.getStatus() != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder
                            .equal(root.get("status"), inputDTO.getStatus())
                    ));
                }
                if (inputDTO.getTotalPoint() != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder
                            .equal(root.get("totalPoint"), inputDTO.getTotalPoint())
                    ));
                }
                if (inputDTO.getClasses() != null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder
                            .equal(root.get("student").get("classes").get("name"), inputDTO.getClasses())
                    ));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        });
        return evaluationForms;
    }

    public EvaluationForm findById(Long id) {
        return evaluationFormRepository.findById(id).get();
    }

    public List<InputDTO> findTargetIsInputDTO(InputDTO inputDTO) {
        List<EvaluationForm> evaluationForms = findByCriteria(inputDTO);

        List<InputDTO> inputDTOS = new ArrayList<>();
        for (EvaluationForm e : evaluationForms) {
            inputDTOS.add(new InputDTO(e.getStudent().getFullName(),
                    e.getSemester().getSemesterNo(),
                    e.getStatus(),
                    e.getTotalPoint(),
                    e.getStudent().getUser().getUsername(),
                    e.getStudent().getClasses().getName()));
        }
        return inputDTOS;
    }

    private void getAttributeFromEvaluation(EvaluationFormOfClassPresident dto, EvaluationForm e) {
    	 dto.setHoc_luc_yeu(e.getHoc_luc_yeu());
         dto.setDi_hoc_dung_gio (e.getDi_hoc_dung_gio());
         dto.setHoc_luc_duoi_trungbinh(e.getHoc_luc_duoi_trungbinh());
         dto.setHoc_luc_gioi(e.getHoc_luc_gioi());
         dto.setHoc_luc_kha(e.getHoc_luc_kha());
         dto.setHoc_luc_trungbinh(e.getHoc_luc_trungbinh());
         dto.setVuot_kho(e.getVuot_kho());
//         dto.setCanh_cao_hoc_vu(e.getCanh_cao_hoc_vu());
//         dto.setDang_ki_khong_du_tin(e.getDang_ki_khong_du_tin());
      
         dto.setCam_thi_bo_thi(e.getCam_thi_bo_thi());
         dto.setCanh_cao(e.getCanh_cao());
         dto.setKhien_trach(e.getKhien_trach());
         dto.setDinh_chi(e.getDinh_chi());
         dto.setTham_gia_hoat_dong(e.getTham_gia_hoat_dong());
//         ExamDiscipline examDiscipline = ExamDisciplindto.convertToEnum(e.getKy_luat_thi());
//         dto.setKy_luat_thi(examDiscipline);

         //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
//         dto.setNop_nhan_kinh_phi(e.getNop_nhan_kinh_phi());
//         dto.setDang_ki_hoc_qua_han(e.getDang_ki_hoc_qua_han());
//         dto.setKhong_thuc_hien_yeu_cau(e.getKhong_thuc_hien_yeu_cau());
//         dto.setTra_qua_han_giay_to(e.getTra_qua_han_giay_to());
//         dto.setKhong_tham_gia_bao_hiem(e.getKhong_tham_gia_bao_hiem());
      // private
     	// 2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
      
         dto.setKhong_dong_hoc_phi(e.getKhong_dong_hoc_phi());
         dto.setVi_pham_quy_dinh_cu_tru(e.getVi_pham_quy_dinh_cu_tru());
         dto.setNghiem_tuc(e.getNghiem_tuc());
         dto.setKhong_hop_lop(e.getKhong_hop_lop());
         dto.setHoi_thao(e.getHoi_thao());
         dto.setVang_hoi_thao(e.getVang_hoi_thao());
//         DisciplinaryDecision disciplinaryDecision = DisciplinaryDecision.convertToEnum(e.getQuyet_dinh_ky_luat());
//         dto.setQuyet_dinh_ky_luat(disciplinaryDecision);

         //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
     	
         dto.setHien_mau(e.getHien_mau());
         dto.setTuyen_truyen(e.getTuyen_truyen());
         dto.setChong_ma_tuy(e.getChong_ma_tuy());
         dto.setSai_lech(e.getSai_lech());
        
         dto.setTham_gia_chi_doan_chinh_tri(e.getTham_gia_chi_doan_chinh_tri());
         dto.setTham_gia_hoat_dong(e.getTham_gia_hoat_dong());
//         dto.setKhong_tham_gia_sinh_hoat(e.getKhong_tham_gia_sinh_hoat());
         //4. về phẩm chất công dân và quan hệ với cộng đồng
     
         dto.setChap_hanh_luat(e.getChap_hanh_luat());
         dto.setTuyen_truyen_dang(e.getTuyen_truyen_dang());
         dto.setQuan_he_dung_muc(e.getQuan_he_dung_muc());
         dto.setQuan_he_dung_tot(e.getQuan_he_dung_tot());
         dto.setKhen_cong_dong(e.getKhen_cong_dong());
         dto.setVi_pham_an_ninh(e.getVi_pham_an_ninh());
        
//         dto.setKhong_co_tinh_than_doan_ket(e.getKhong_co_tinh_than_doan_ket());
         //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
         // được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
       
     	 dto.setTham_gia_clb(e.getTham_gia_clb());
      
         dto.setGiu_chuc_vu(e.getGiu_chuc_vu());
         dto.setHoc_luc_gioi_xuat_sac(e.getHoc_luc_gioi_xuat_sac());
//         dto.setChung_chi_tieng_Anh(e.getChung_chi_tieng_Anh());
//         dto.setTham_gia_cuoc_thi(e.getTham_gia_cuoc_thi());
//         dto.setDat_giai_cuoc_thi(e.getDat_giai_cuoc_thi());
//         dto.setTham_gia_NCKH(e.getTham_gia_NCKH());
         dto.setDat_giai_NCKH(e.getDat_giai_NCKH());
//         dto.setKet_nap_Dang(dto.getKet_nap_Dang());
//        dto.setHoc_luc_yeu(e.getHoc_luc_yeu());
////        dto.setCanh_cao_hoc_vu(e.getCanh_cao_hoc_vu());
////        dto.setDang_ki_khong_du_tin(e.getDang_ki_khong_du_tin());
//        dto.setCam_thi_bo_thi(e.getCam_thi_bo_thi());
////        dto.setKy_luat_thi(e.getKy_luat_thi());
//
//        //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
////        dto.setNop_nhan_kinh_phi(e.getNop_nhan_kinh_phi());
////        dto.setDang_ki_hoc_qua_han(e.getDang_ki_hoc_qua_han());
////        dto.setKhong_thuc_hien_yeu_cau(e.getKhong_thuc_hien_yeu_cau());
////        dto.setTra_qua_han_giay_to(e.getTra_qua_han_giay_to());
////        dto.setKhong_tham_gia_bao_hiem(e.getKhong_tham_gia_bao_hiem());
//        dto.setVi_pham_quy_dinh_cu_tru(e.getVi_pham_quy_dinh_cu_tru());
////        dto.setQuyet_dinh_ky_luat(e.getQuyet_dinh_ky_luat());
//
//        //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
//        dto.setTham_gia_chi_doan_chinh_tri(e.getTham_gia_chi_doan_chinh_tri());
//        dto.setTham_gia_hoat_dong(e.getTham_gia_hoat_dong());
////        dto.setKhong_tham_gia_sinh_hoat(e.getKhong_tham_gia_sinh_hoat());
//        //4. về phẩm chất công dân và quan hệ với cộng đồng
//        dto.setChap_hanh_luat(e.getChap_hanh_luat());
////        dto.setKhong_co_tinh_than_doan_ket(e.getKhong_co_tinh_than_doan_ket());
//        //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
//        // được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
//        dto.setGiu_chuc_vu(e.getGiu_chuc_vu());
//        dto.setHoc_luc_gioi_xuat_sac(e.getHoc_luc_gioi_xuat_sac());
////        dto.setChung_chi_tieng_Anh(e.getChung_chi_tieng_Anh());
////        dto.setTham_gia_cuoc_thi(e.getTham_gia_cuoc_thi());
////        dto.setDat_giai_cuoc_thi(e.getDat_giai_cuoc_thi());
////        dto.setTham_gia_NCKH(e.getTham_gia_NCKH());
//        dto.setDat_giai_NCKH(e.getDat_giai_NCKH());
////        dto.setKet_nap_Dang(e.getKet_nap_Dang());

        dto.setTotalPoint(e.getTotalPoint());
    }

    private void getAttributeFromDTO(EvaluationForm e, EvaluationFormDTO dto){
    	 e.setHoc_luc_yeu(dto.getHoc_luc_yeu());
         e.setDi_hoc_dung_gio (dto.getDi_hoc_dung_gio());
         e.setHoc_luc_duoi_trungbinh(dto.getHoc_luc_duoi_trungbinh());
         e.setHoc_luc_gioi(dto.getHoc_luc_gioi());
         e.setHoc_luc_kha(dto.getHoc_luc_kha());
         e.setHoc_luc_trungbinh(dto.getHoc_luc_trungbinh());
         e.setVuot_kho(dto.getVuot_kho());
//         e.setCanh_cao_hoc_vu(dto.getCanh_cao_hoc_vu());
//         e.setDang_ki_khong_du_tin(dto.getDang_ki_khong_du_tin());
      
         e.setCam_thi_bo_thi(dto.getCam_thi_bo_thi());
         e.setCanh_cao(dto.getCanh_cao());
         e.setKhien_trach(dto.getKhien_trach());
         e.setDinh_chi(dto.getDinh_chi());
         e.setTham_gia_hoat_dong(dto.getTham_gia_hoat_dong());
//         ExamDiscipline examDiscipline = ExamDiscipline.convertToEnum(dto.getKy_luat_thi());
//         e.setKy_luat_thi(examDiscipline);

         //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
//         e.setNop_nhan_kinh_phi(dto.getNop_nhan_kinh_phi());
//         e.setDang_ki_hoc_qua_han(dto.getDang_ki_hoc_qua_han());
//         e.setKhong_thuc_hien_yeu_cau(dto.getKhong_thuc_hien_yeu_cau());
//         e.setTra_qua_han_giay_to(dto.getTra_qua_han_giay_to());
//         e.setKhong_tham_gia_bao_hiem(dto.getKhong_tham_gia_bao_hiem());
      // private
     	// 2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
      
         e.setKhong_dong_hoc_phi(dto.getKhong_dong_hoc_phi());
         e.setVi_pham_quy_dinh_cu_tru(dto.getVi_pham_quy_dinh_cu_tru());
         e.setNghiem_tuc(dto.getNghiem_tuc());
         e.setKhong_hop_lop(dto.getKhong_hop_lop());
         e.setHoi_thao(dto.getHoi_thao());
         e.setVang_hoi_thao(dto.getVang_hoi_thao());
//         DisciplinaryDecision disciplinaryDecision = DisciplinaryDecision.convertToEnum(dto.getQuyet_dinh_ky_luat());
//         e.setQuyet_dinh_ky_luat(disciplinaryDecision);

         //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
     	
         e.setHien_mau(dto.getHien_mau());
         e.setTuyen_truyen(dto.getTuyen_truyen());
         e.setChong_ma_tuy(dto.getChong_ma_tuy());
         e.setSai_lech(dto.getSai_lech());
        
         e.setTham_gia_chi_doan_chinh_tri(dto.getTham_gia_chi_doan_chinh_tri());
         e.setTham_gia_hoat_dong(dto.getTham_gia_hoat_dong());
//         e.setKhong_tham_gia_sinh_hoat(dto.getKhong_tham_gia_sinh_hoat());
         //4. về phẩm chất công dân và quan hệ với cộng đồng
     
         e.setChap_hanh_luat(dto.getChap_hanh_luat());
         e.setTuyen_truyen_dang(dto.getTuyen_truyen_dang());
         e.setQuan_he_dung_muc(dto.getQuan_he_dung_muc());
         e.setQuan_he_dung_tot(dto.getQuan_he_dung_tot());
         e.setKhen_cong_dong(dto.getKhen_cong_dong());
         e.setVi_pham_an_ninh(dto.getVi_pham_an_ninh());
        
//         e.setKhong_co_tinh_than_doan_ket(dto.getKhong_co_tinh_than_doan_ket());
         //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
         // được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
       
     	 e.setTham_gia_clb(dto.getTham_gia_clb());
      
         e.setGiu_chuc_vu(dto.getGiu_chuc_vu());
         e.setHoc_luc_gioi_xuat_sac(dto.getHoc_luc_gioi_xuat_sac());
//         e.setChung_chi_tieng_Anh(dto.getChung_chi_tieng_Anh());
//         e.setTham_gia_cuoc_thi(dto.getTham_gia_cuoc_thi());
//         e.setDat_giai_cuoc_thi(dto.getDat_giai_cuoc_thi());
//         e.setTham_gia_NCKH(dto.getTham_gia_NCKH());
         e.setDat_giai_NCKH(dto.getDat_giai_NCKH());
//         e.setKet_nap_Dang(dto.getKet_nap_Dang());
//        e.setHoc_luc_yeu(dto.getHoc_luc_yeu());
////        e.setCanh_cao_hoc_vu(dto.getCanh_cao_hoc_vu());
////        e.setDang_ki_khong_du_tin(dto.getDang_ki_khong_du_tin());
//        e.setCam_thi_bo_thi(dto.getCam_thi_bo_thi());
////        ExamDiscipline examDiscipline = ExamDiscipline.convertToEnum(dto.getKy_luat_thi());
////        e.setKy_luat_thi(examDiscipline);
//
//        //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
////        e.setNop_nhan_kinh_phi(dto.getNop_nhan_kinh_phi());
////        e.setDang_ki_hoc_qua_han(dto.getDang_ki_hoc_qua_han());
////        e.setKhong_thuc_hien_yeu_cau(dto.getKhong_thuc_hien_yeu_cau());
////        e.setTra_qua_han_giay_to(dto.getTra_qua_han_giay_to());
////        e.setKhong_tham_gia_bao_hiem(dto.getKhong_tham_gia_bao_hiem());
//        e.setVi_pham_quy_dinh_cu_tru(dto.getVi_pham_quy_dinh_cu_tru());
////        DisciplinaryDecision disciplinaryDecision = DisciplinaryDecision.convertToEnum(dto.getQuyet_dinh_ky_luat());
////        e.setQuyet_dinh_ky_luat(disciplinaryDecision);
//
//        //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
//        e.setTham_gia_chi_doan_chinh_tri(dto.getTham_gia_chi_doan_chinh_tri());
//        e.setTham_gia_hoat_dong(dto.getTham_gia_hoat_dong());
////        e.setKhong_tham_gia_sinh_hoat(dto.getKhong_tham_gia_sinh_hoat());
//        //4. về phẩm chất công dân và quan hệ với cộng đồng
//        e.setChap_hanh_luat(dto.getChap_hanh_luat());
////        e.setKhong_co_tinh_than_doan_ket(dto.getKhong_co_tinh_than_doan_ket());
//        //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
//        // được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
//        e.setGiu_chuc_vu(dto.getGiu_chuc_vu());
//        e.setHoc_luc_gioi_xuat_sac(dto.getHoc_luc_gioi_xuat_sac());
////        e.setChung_chi_tieng_Anh(dto.getChung_chi_tieng_Anh());
////        e.setTham_gia_cuoc_thi(dto.getTham_gia_cuoc_thi());
////        e.setDat_giai_cuoc_thi(dto.getDat_giai_cuoc_thi());
////        e.setTham_gia_NCKH(dto.getTham_gia_NCKH());
//        e.setDat_giai_NCKH(dto.getDat_giai_NCKH());
////        e.setKet_nap_Dang(dto.getKet_nap_Dang());

        e.setTotalPoint(dto.getTotalPoint());
    }


    public void save(EvaluationForm evaluationForm) {
        if (evaluationForm.getStatus().toString().equals("PENDING_APPROVAL_OF_CLASS_PRESIDENT")) {
            //nếu bước này là nộp cho lớp trưởng thì sẽ tạo form mới y hệt
            EvaluationFormOfClassPresident president = new EvaluationFormOfClassPresident();
            getAttributeFromEvaluation(president, evaluationForm);
            evaluationForm.setEvaluationFormOfClassPresident(president);

//            System.out.println(president);
            evaluationFormOfClassPresidentRepository.save(president);
        }

        //set thông tin thay đổi vào phiếu điểm
//        convertTargetEntity(evaluationFormDTO, evaluationForm);
        evaluationFormRepository.save(evaluationForm);
    }

}
