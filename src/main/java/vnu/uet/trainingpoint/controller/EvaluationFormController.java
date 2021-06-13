package vnu.uet.trainingpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vnu.uet.trainingpoint.enitty.EvaluationForm;
import vnu.uet.trainingpoint.enitty.EvaluationFormOfClassPresident;
import vnu.uet.trainingpoint.model.DisciplinaryDecision;
import vnu.uet.trainingpoint.model.ExamDiscipline;
import vnu.uet.trainingpoint.model.Status;
import vnu.uet.trainingpoint.model.dto.EvaluationFormDTO;
import vnu.uet.trainingpoint.service.EvaluationFormOfClassPresidentService;
import vnu.uet.trainingpoint.service.EvaluationFormService;

@Controller
public class EvaluationFormController {

    private EvaluationFormService evaluationFormService;

    private EvaluationFormOfClassPresidentService evaluationFormOfClassPresidentService;

    @Autowired
    public void setEvaluationFormOfClassPresidentService(EvaluationFormOfClassPresidentService evaluationFormOfClassPresidentService) {
        this.evaluationFormOfClassPresidentService = evaluationFormOfClassPresidentService;
    }

    @Autowired
    public void setEvaluationFormService(EvaluationFormService evaluationFormService) {
        this.evaluationFormService = evaluationFormService;
    }

    // gửi lên lớp trưởng
    @PostMapping("/saveEvaluationFormOfStudent")
    public String saveEvaluationForm(@ModelAttribute("evaluationFormDTO") EvaluationFormDTO data){
        System.out.println(data);

        EvaluationForm evaluationForm= evaluationFormService.findById(data.getId());

        // convert status from front end
        getAttributeFromDTO(evaluationForm, data);

//        evaluationForm.setTotalPoint(evaluationFormFake.getTotalPoint());
        evaluationForm.setStatus(Status.PENDING_APPROVAL_OF_CLASS_PRESIDENT);
        // convert status from front end
        evaluationFormService.save(evaluationForm);

        //save
        return "redirect:/student";
    }

    //gửi lên lớp trưởng
    @PostMapping("/saveEvaluationFormOfMyselfMonitor")
    public String saveEvaluationFormOfMyselfMonitor(@ModelAttribute("evaluationForm") EvaluationFormDTO data){

        System.out.println(data);

        EvaluationForm evaluationForm= evaluationFormService.findById(data.getId());
        // convert status from front end
        getAttributeFromDTO(evaluationForm, data);

        evaluationForm.setStatus(Status.PENDING_APPROVAL_OF_CLASS_PRESIDENT);
        // convert status from front end
        evaluationFormService.save(evaluationForm);

        //save
        return "redirect:/monitor/studentPoint";
    }

    //gửi lên cố vấn
    @PostMapping("/saveEvaluationFormOfMonitor")
    public String saveEvaluationFormOfMonitor(@ModelAttribute("e1") EvaluationForm data){

        System.out.println(data);

        EvaluationForm evaluationForm= evaluationFormService.findById(data.getId());
        // convert status from front end
        EvaluationFormOfClassPresident president= evaluationForm.getEvaluationFormOfClassPresident();
        getAttributeFromDTO(president,
                data.getEvaluationFormOfClassPresident());

        //save evaluationFormOfClassPresident
        evaluationFormOfClassPresidentService.save(president);

        evaluationForm.setStatus(Status.PENDING_APPROVAL_OF_CONSULTANT);
        // convert status from front end

        //save evaluation
        evaluationFormService.save(evaluationForm);
        return "redirect:/monitor/classList";
    }

    //sucess
    @PostMapping("/saveEvaluationFormOfConsultant")
    public String saveEvaluationFormOfConsultant(@ModelAttribute("e2") EvaluationForm data){

        System.out.println(data);

        EvaluationForm evaluationForm= evaluationFormService.findById(data.getId());
        // convert status from front end

        EvaluationFormOfClassPresident president= evaluationForm.getEvaluationFormOfClassPresident();
        getAttributeFromDTO(president,
                data.getEvaluationFormOfClassPresident());

        //save evaluationFormOfClassPresident
        evaluationFormOfClassPresidentService.save(president);

        // convert status from front end
        evaluationForm.setTotalPoint(president.autoGenerateTotalPoint());

        //change status
        evaluationForm.setStatus(Status.SUCCESS);

        //save
        evaluationFormService.save(evaluationForm);

        return "redirect:/consultant/studentList";
    }

    private void getAttributeFromDTO(EvaluationFormOfClassPresident e, EvaluationFormOfClassPresident data){

        e.setHoc_luc_yeu(data.getHoc_luc_yeu());
        e.setCanh_cao_hoc_vu(data.getCanh_cao_hoc_vu());
        e.setDang_ki_khong_du_tin(data.getDang_ki_khong_du_tin());
        e.setCam_thi_bo_thi(data.getCam_thi_bo_thi());
        e.setKy_luat_thi(data.getKy_luat_thi());

        //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
        e.setNop_nhan_kinh_phi(data.getNop_nhan_kinh_phi());
        e.setDang_ki_hoc_qua_han(data.getDang_ki_hoc_qua_han());
        e.setKhong_thuc_hien_yeu_cau(data.getKhong_thuc_hien_yeu_cau());
        e.setTra_qua_han_giay_to(data.getTra_qua_han_giay_to());
        e.setKhong_tham_gia_bao_hiem(data.getKhong_tham_gia_bao_hiem());
        e.setVi_pham_quy_dinh_cu_tru(data.getVi_pham_quy_dinh_cu_tru());
        e.setQuyet_dinh_ky_luat(data.getQuyet_dinh_ky_luat());

        //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
        e.setTham_gia_chi_doan_chinh_tri(data.getTham_gia_chi_doan_chinh_tri());
        e.setTham_gia_hoat_dong(data.getTham_gia_hoat_dong());
        e.setKhong_tham_gia_sinh_hoat(data.getKhong_tham_gia_sinh_hoat());
        //4. về phẩm chất công dân và quan hệ với cộng đồng
        e.setKhong_chap_hanh_luat(data.getKhong_chap_hanh_luat());
        e.setKhong_co_tinh_than_doan_ket(data.getKhong_co_tinh_than_doan_ket());
        //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
        // được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
        e.setGiu_chuc_vu(data.getGiu_chuc_vu());
        e.setHoc_luc_gioi_xuat_sac(data.getHoc_luc_gioi_xuat_sac());
        e.setChung_chi_tieng_Anh(data.getChung_chi_tieng_Anh());
        e.setTham_gia_cuoc_thi(data.getTham_gia_cuoc_thi());
        e.setDat_giai_cuoc_thi(data.getDat_giai_cuoc_thi());
        e.setTham_gia_NCKH(data.getTham_gia_NCKH());
        e.setDat_giai_NCKH(data.getDat_giai_NCKH());
        e.setKet_nap_Dang(data.getKet_nap_Dang());

        e.setTotalPoint(data.autoGenerateTotalPoint());
    }

    private void getAttributeFromDTO(EvaluationForm e, EvaluationFormDTO dto){

        e.setHoc_luc_yeu(dto.getHoc_luc_yeu());
        e.setCanh_cao_hoc_vu(dto.getCanh_cao_hoc_vu());
        e.setDang_ki_khong_du_tin(dto.getDang_ki_khong_du_tin());
        e.setCam_thi_bo_thi(dto.getCam_thi_bo_thi());
        ExamDiscipline examDiscipline = ExamDiscipline.convertToEnum(dto.getKy_luat_thi());
        e.setKy_luat_thi(examDiscipline);

        //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
        e.setNop_nhan_kinh_phi(dto.getNop_nhan_kinh_phi());
        e.setDang_ki_hoc_qua_han(dto.getDang_ki_hoc_qua_han());
        e.setKhong_thuc_hien_yeu_cau(dto.getKhong_thuc_hien_yeu_cau());
        e.setTra_qua_han_giay_to(dto.getTra_qua_han_giay_to());
        e.setKhong_tham_gia_bao_hiem(dto.getKhong_tham_gia_bao_hiem());
        e.setVi_pham_quy_dinh_cu_tru(dto.getVi_pham_quy_dinh_cu_tru());
        DisciplinaryDecision disciplinaryDecision = DisciplinaryDecision.convertToEnum(dto.getQuyet_dinh_ky_luat());
        e.setQuyet_dinh_ky_luat(disciplinaryDecision);

        //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
        e.setTham_gia_chi_doan_chinh_tri(dto.getTham_gia_chi_doan_chinh_tri());
        e.setTham_gia_hoat_dong(dto.getTham_gia_hoat_dong());
        e.setKhong_tham_gia_sinh_hoat(dto.getKhong_tham_gia_sinh_hoat());
        //4. về phẩm chất công dân và quan hệ với cộng đồng
        e.setKhong_chap_hanh_luat(dto.getKhong_chap_hanh_luat());
        e.setKhong_co_tinh_than_doan_ket(dto.getKhong_co_tinh_than_doan_ket());
        //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
        // được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
        e.setGiu_chuc_vu(dto.getGiu_chuc_vu());
        e.setHoc_luc_gioi_xuat_sac(dto.getHoc_luc_gioi_xuat_sac());
        e.setChung_chi_tieng_Anh(dto.getChung_chi_tieng_Anh());
        e.setTham_gia_cuoc_thi(dto.getTham_gia_cuoc_thi());
        e.setDat_giai_cuoc_thi(dto.getDat_giai_cuoc_thi());
        e.setTham_gia_NCKH(dto.getTham_gia_NCKH());
        e.setDat_giai_NCKH(dto.getDat_giai_NCKH());
        e.setKet_nap_Dang(dto.getKet_nap_Dang());

        e.setTotalPoint(dto.autoGenerateTotalPoint());
    }
}
