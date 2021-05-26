package vnu.uet.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vnu.uet.trainingpoint.enitty.EvaluationForm;
import vnu.uet.trainingpoint.enitty.User;
import vnu.uet.trainingpoint.model.dto.EvaluationFormDTO;
import vnu.uet.trainingpoint.repository.EvaluationFormRepository;
import vnu.uet.trainingpoint.repository.StudentRepository;
import vnu.uet.trainingpoint.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluationFormService {

    private EvaluationFormRepository evaluationFormRepository;

    private UserRepository userRepository;

    private StudentRepository studentRepository;

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

    public ResponseEntity<EvaluationFormDTO> find(String username, Integer semester){
        Optional<EvaluationForm> evaluationFormOptional =
                evaluationFormRepository.getByUsernameAndSemester(username, semester);
        return evaluationFormOptional.map(evaluationForm -> new ResponseEntity<>(
                genEvaluationFormDTO(evaluationForm), HttpStatus.OK
        )).orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    public List<EvaluationFormDTO> getFullEvaluationFormBySemester(Integer semesterNo){
        List<EvaluationForm> evaluationForms=evaluationFormRepository.getListBySemester(semesterNo);
        List<EvaluationFormDTO> evaluationFormDTOS= new ArrayList<>();
        for(EvaluationForm e: evaluationForms){
            evaluationFormDTOS.add(genEvaluationFormDTO(e));
        }
        return evaluationFormDTOS;
    }


    private EvaluationFormDTO genEvaluationFormDTO(EvaluationForm evaluationForm){
        //ý thức học tập
        EvaluationFormDTO e=new EvaluationFormDTO();
        e.setStudent_id(evaluationForm.getStudent().getId());
        e.setSemester(evaluationForm.getSemester().getSemesterNo());

        e.setHoc_luc_yeu(evaluationForm.getHoc_luc_yeu());
        e.setCanh_cao_hoc_vu(evaluationForm.getCanh_cao_hoc_vu());
        e.setDang_ki_khong_du_tin(evaluationForm.getDang_ki_khong_du_tin());
        e.setCam_thi_bo_thi(evaluationForm.getCam_thi_bo_thi());
        e.setKy_luat_thi(evaluationForm.getKy_luat_thi());

        //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
        e.setNop_nhan_kinh_phi(evaluationForm.getNop_nhan_kinh_phi());
        e.setDang_ki_hoc_qua_han(evaluationForm.getDang_ki_hoc_qua_han());
        e.setKhong_thuc_hien_yeu_cau(evaluationForm.getKhong_thuc_hien_yeu_cau());
        e.setTra_qua_han_giay_to(evaluationForm.getTra_qua_han_giay_to());
        e.setKhong_tham_gia_bao_hiem(evaluationForm.getKhong_tham_gia_bao_hiem());
        e.setVi_pham_quy_dinh_cu_tru(evaluationForm.getVi_pham_quy_dinh_cu_tru());
        e.setQuyet_dinh_ky_luat(evaluationForm.getQuyet_dinh_ky_luat());

        //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
        e.setTham_gia_chi_doan_chinh_tri(evaluationForm.getTham_gia_chi_doan_chinh_tri());
        e.setTham_gia_hoat_dong(evaluationForm.getTham_gia_hoat_dong());
        e.setKhong_tham_gia_sinh_hoat(evaluationForm.getKhong_tham_gia_sinh_hoat());
        //4. về phẩm chất công dân và quan hệ với cộng đồng
        e.setKhong_chap_hanh_luat(evaluationForm.getKhong_chap_hanh_luat());
        e.setKhong_co_tinh_than_doan_ket(evaluationForm.getKhong_co_tinh_than_doan_ket());

        //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
        // được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
        e.setGiu_chuc_vu(evaluationForm.getGiu_chuc_vu());
        e.setHoc_luc_gioi_xuat_sac(evaluationForm.getHoc_luc_gioi_xuat_sac());
        e.setChung_chi_tieng_Anh(evaluationForm.getChung_chi_tieng_Anh());
        e.setTham_gia_cuoc_thi(evaluationForm.getTham_gia_cuoc_thi());
        e.setDat_giai_cuoc_thi(evaluationForm.getDat_giai_cuoc_thi());
        e.setTham_gia_NCKH(evaluationForm.getTham_gia_NCKH());
        e.setDat_giai_NCKH(evaluationForm.getDat_giai_NCKH());
        e.setKet_nap_Dang(evaluationForm.getKet_nap_Dang());

        e.setStatus(evaluationForm.getStatus());
        e.setTotalPoint(evaluationForm.getTotalPoint());
        return e;
    }
}
