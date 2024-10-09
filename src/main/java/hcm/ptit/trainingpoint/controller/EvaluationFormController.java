package hcm.ptit.trainingpoint.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hcm.ptit.trainingpoint.enitty.EvaluationForm;
import hcm.ptit.trainingpoint.enitty.EvaluationFormOfClassPresident;
import hcm.ptit.trainingpoint.enitty.StudentQuestion;
import hcm.ptit.trainingpoint.model.DisciplinaryDecision;
import hcm.ptit.trainingpoint.model.ExamDiscipline;
import hcm.ptit.trainingpoint.model.Status;
import hcm.ptit.trainingpoint.model.dto.EvaluationFormDTO;
import hcm.ptit.trainingpoint.service.EvaluationFormOfClassPresidentService;
import hcm.ptit.trainingpoint.service.EvaluationFormService;
import hcm.ptit.trainingpoint.service.StudentQuestionService;

@Controller
public class EvaluationFormController {

	private EvaluationFormService evaluationFormService;

	private StudentQuestionService studentQuestionService;

	private EvaluationFormOfClassPresidentService evaluationFormOfClassPresidentService;

	@Autowired 
	public void setEvaluationFormOfClassPresidentService(
			EvaluationFormOfClassPresidentService evaluationFormOfClassPresidentService) {
		this.evaluationFormOfClassPresidentService = evaluationFormOfClassPresidentService;
	}

	@Autowired
	public void setStudentQuestionService(StudentQuestionService studentQuestionService) {
		this.studentQuestionService = studentQuestionService;
	}

	@Autowired
	public void setEvaluationFormService(EvaluationFormService evaluationFormService) {
		this.evaluationFormService = evaluationFormService;
	}

	// gửi lên lớp trưởng
	@PostMapping("/saveEvaluationFormOfStudent")
	public String saveEvaluationForm(@ModelAttribute("evaluationFormDTO") EvaluationFormDTO data) {
		System.out.println(data);

		EvaluationForm evaluationForm = evaluationFormService.findById(data.getId());

		// convert status from front end
		getAttributeFromDTO(evaluationForm, data);

//        evaluationForm.setTotalPoint(evaluationFormFake.getTotalPoint());
		evaluationForm.setStatus(Status.PENDING_APPROVAL_OF_CLASS_PRESIDENT);
		// convert status from front end
		evaluationFormService.save(evaluationForm);

		// save
		return "redirect:/student/studentPoint";
	}

	// gửi lên lớp trưởng
	@PostMapping("/saveEvaluationFormOfMyselfMonitor")
	public String saveEvaluationFormOfMyselfMonitor(@ModelAttribute("evaluationForm") EvaluationFormDTO data) {

		System.out.println(data);

		EvaluationForm evaluationForm = evaluationFormService.findById(data.getId());
		// convert status from front end
		getAttributeFromDTO(evaluationForm, data);

		evaluationForm.setStatus(Status.PENDING_APPROVAL_OF_CLASS_PRESIDENT);
		// convert status from front end
		evaluationFormService.save(evaluationForm);

		// save
		return "redirect:/monitor/studentPoint";
	}

	// gửi lên cố vấn
	@PostMapping("/saveEvaluationFormOfMonitor")
	public String saveEvaluationFormOfMonitor(@ModelAttribute("e1") EvaluationForm data) {

		System.out.println(data);

		EvaluationForm evaluationForm = evaluationFormService.findById(data.getId());
		// convert status from front end
		EvaluationFormOfClassPresident president = evaluationForm.getEvaluationFormOfClassPresident();
		getAttributeFromDTO(president, data.getEvaluationFormOfClassPresident());

		// save evaluationFormOfClassPresident
		evaluationFormOfClassPresidentService.save(president);

		evaluationForm.setStatus(Status.PENDING_APPROVAL_OF_CONSULTANT);
		// convert status from front end

		// save evaluation
		evaluationFormService.save(evaluationForm);
		return "redirect:/monitor/classList";
	}

	// sucess
	@PostMapping("/saveEvaluationFormOfConsultant")
	public String saveEvaluationFormOfConsultant(@ModelAttribute("e2") EvaluationForm data) {

		System.out.println(data);

		EvaluationForm evaluationForm = evaluationFormService.findById(data.getId());
		// convert status from front end

		EvaluationFormOfClassPresident president = evaluationForm.getEvaluationFormOfClassPresident();
		getAttributeFromDTO(president, data.getEvaluationFormOfClassPresident());

		// save evaluationFormOfClassPresident
		evaluationFormOfClassPresidentService.save(president);

		// convert status from front end
		evaluationForm.setTotalPoint(president.autoGenerateTotalPoint());

		// change status
		evaluationForm.setStatus(Status.SUCCESS);

		// save
		evaluationFormService.save(evaluationForm);

		return "redirect:/consultant/studentList";
	}

	@PostMapping("/reviewQuestion")
	public String reviewQuestion(@ModelAttribute("evaluation") EvaluationForm data,
			@RequestParam("inputImage") List<MultipartFile> files) throws IOException {

		System.out.println("data: "+ data.getStudentQuestion().getQuestion1());

		EvaluationForm evaluationForm = evaluationFormService.findById(data.getId());
		
		// convert status from front end	
//        evaluationFormService.saveReviewQuestion(evaluation);
//         evaluationForm.setTotalPoint(evaluationFormFake.getTotalPoint());
		studentQuestionService.uploadImageToFileSystem(data, files);
		evaluationForm.setStatus(Status.QUESTION);
		
		evaluationFormService.save(evaluationForm);
		// convert status from front end

		// save
		return "redirect:/student";

	}

	private void getAttributeFromDTO(EvaluationFormOfClassPresident e, EvaluationFormOfClassPresident data) {

		e.setHoc_luc_yeu(data.getHoc_luc_yeu());
		e.setDi_hoc_dung_gio(data.getDi_hoc_dung_gio());
		e.setHoc_luc_duoi_trungbinh(data.getHoc_luc_duoi_trungbinh());
		e.setHoc_luc_gioi(data.getHoc_luc_gioi());
		e.setHoc_luc_kha(data.getHoc_luc_kha());
		e.setHoc_luc_trungbinh(data.getHoc_luc_trungbinh());
		e.setVuot_kho(data.getVuot_kho());
//         e.setCanh_cao_hoc_vu(data.getCanh_cao_hoc_vu());
//         e.setDang_ki_khong_du_tin(data.getDang_ki_khong_du_tin());

		e.setCam_thi_bo_thi(data.getCam_thi_bo_thi());
		e.setCanh_cao(data.getCanh_cao());
		e.setKhien_trach(data.getKhien_trach());
		e.setDinh_chi(data.getDinh_chi());
		e.setTham_gia_hoat_dong(data.getTham_gia_hoat_dong());
//         ExamDiscipline examDiscipline = ExamDiscipline.convertToEnum(data.getKy_luat_thi());
//         e.setKy_luat_thi(examDiscipline);

		// 2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
//         e.setNop_nhan_kinh_phi(data.getNop_nhan_kinh_phi());
//         e.setDang_ki_hoc_qua_han(data.getDang_ki_hoc_qua_han());
//         e.setKhong_thuc_hien_yeu_cau(data.getKhong_thuc_hien_yeu_cau());
//         e.setTra_qua_han_giay_to(data.getTra_qua_han_giay_to());
//         e.setKhong_tham_gia_bao_hiem(data.getKhong_tham_gia_bao_hiem());
		// private
		// 2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường

		e.setKhong_dong_hoc_phi(data.getKhong_dong_hoc_phi());
		e.setVi_pham_quy_dinh_cu_tru(data.getVi_pham_quy_dinh_cu_tru());
		e.setNghiem_tuc(data.getNghiem_tuc());
		e.setKhong_hop_lop(data.getKhong_hop_lop());
		e.setHoi_thao(data.getHoi_thao());
		e.setVang_hoi_thao(data.getVang_hoi_thao());
//         DisciplinaryDecision disciplinaryDecision = DisciplinaryDecision.convertToEnum(data.getQuyet_dinh_ky_luat());
//         e.setQuyet_dinh_ky_luat(disciplinaryDecision);

		// 3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...

		e.setHien_mau(data.getHien_mau());
		e.setTuyen_truyen(data.getTuyen_truyen());
		e.setChong_ma_tuy(data.getChong_ma_tuy());
		e.setSai_lech(data.getSai_lech());

		e.setTham_gia_chi_doan_chinh_tri(data.getTham_gia_chi_doan_chinh_tri());
		e.setTham_gia_hoat_dong(data.getTham_gia_hoat_dong());
//         e.setKhong_tham_gia_sinh_hoat(data.getKhong_tham_gia_sinh_hoat());
		// 4. về phẩm chất công dân và quan hệ với cộng đồng

		e.setChap_hanh_luat(data.getChap_hanh_luat());
		e.setTuyen_truyen_dang(data.getTuyen_truyen_dang());
		e.setQuan_he_dung_muc(data.getQuan_he_dung_muc());
		e.setQuan_he_dung_tot(data.getQuan_he_dung_tot());
		e.setKhen_cong_dong(data.getKhen_cong_dong());
		e.setVi_pham_an_ninh(data.getVi_pham_an_ninh());

//         e.setKhong_co_tinh_than_doan_ket(data.getKhong_co_tinh_than_doan_ket());
		// 5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức
		// trong nhà trường, hoặc đạt
		// được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên

		e.setTham_gia_clb(data.getTham_gia_clb());

		e.setGiu_chuc_vu(data.getGiu_chuc_vu());
		e.setHoc_luc_gioi_xuat_sac(data.getHoc_luc_gioi_xuat_sac());
//         e.setChung_chi_tieng_Anh(data.getChung_chi_tieng_Anh());
//         e.setTham_gia_cuoc_thi(data.getTham_gia_cuoc_thi());
//         e.setDat_giai_cuoc_thi(data.getDat_giai_cuoc_thi());
//         e.setTham_gia_NCKH(data.getTham_gia_NCKH());
		e.setDat_giai_NCKH(data.getDat_giai_NCKH());
//         e.setKet_nap_Dang(dto.getKet_nap_Dang());
//        e.setHoc_luc_yeu(data.getHoc_luc_yeu());
////        e.setCanh_cao_hoc_vu(data.getCanh_cao_hoc_vu());
////        e.setDang_ki_khong_du_tin(data.getDang_ki_khong_du_tin());
//        e.setCam_thi_bo_thi(data.getCam_thi_bo_thi());
////        e.setKy_luat_thi(data.getKy_luat_thi());
//
//        //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
////        e.setNop_nhan_kinh_phi(data.getNop_nhan_kinh_phi());
////        e.setDang_ki_hoc_qua_han(data.getDang_ki_hoc_qua_han());
////        e.setKhong_thuc_hien_yeu_cau(data.getKhong_thuc_hien_yeu_cau());
////        e.setTra_qua_han_giay_to(data.getTra_qua_han_giay_to());
////        e.setKhong_tham_gia_bao_hiem(data.getKhong_tham_gia_bao_hiem());
//        e.setVi_pham_quy_dinh_cu_tru(data.getVi_pham_quy_dinh_cu_tru());
//        e.setQuyet_dinh_ky_luat(data.getQuyet_dinh_ky_luat());
//
//        //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
//        e.setTham_gia_chi_doan_chinh_tri(data.getTham_gia_chi_doan_chinh_tri());
//        e.setTham_gia_hoat_dong(data.getTham_gia_hoat_dong());
////        e.setKhong_tham_gia_sinh_hoat(data.getKhong_tham_gia_sinh_hoat());
//        //4. về phẩm chất công dân và quan hệ với cộng đồng
//        e.setChap_hanh_luat(data.getChap_hanh_luat());
////        e.setKhong_co_tinh_than_doan_ket(data.getKhong_co_tinh_than_doan_ket());
//        //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
//        // được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
//        e.setGiu_chuc_vu(data.getGiu_chuc_vu());
//        e.setHoc_luc_gioi_xuat_sac(data.getHoc_luc_gioi_xuat_sac());
////        e.setChung_chi_tieng_Anh(data.getChung_chi_tieng_Anh());
////        e.setTham_gia_cuoc_thi(data.getTham_gia_cuoc_thi());
////        e.setDat_giai_cuoc_thi(data.getDat_giai_cuoc_thi());
////        e.setTham_gia_NCKH(data.getTham_gia_NCKH());
////        e.setDat_giai_NCKH(data.getDat_giai_NCKH());
////        e.setKet_nap_Dang(data.getKet_nap_Dang());

		e.setTotalPoint(data.autoGenerateTotalPoint());
	}

	private void getAttributeFromDTO(EvaluationForm e, EvaluationFormDTO dto) {

		e.setHoc_luc_yeu(dto.getHoc_luc_yeu());
		e.setDi_hoc_dung_gio(dto.getDi_hoc_dung_gio());
		e.setHoc_luc_duoi_trungbinh(dto.getHoc_luc_duoi_trungbinh());
		e.setHoc_luc_gioi(dto.getHoc_luc_gioi());
		e.setHoc_luc_kha(dto.getHoc_luc_kha());
		e.setHoc_luc_trungbinh(dto.getHoc_luc_trungbinh());
		e.setVuot_kho(dto.getVuot_kho());
//        e.setCanh_cao_hoc_vu(dto.getCanh_cao_hoc_vu());
//        e.setDang_ki_khong_du_tin(dto.getDang_ki_khong_du_tin());

		e.setCam_thi_bo_thi(dto.getCam_thi_bo_thi());
		e.setCanh_cao(dto.getCanh_cao());
		e.setKhien_trach(dto.getKhien_trach());
		e.setDinh_chi(dto.getDinh_chi());
		e.setTham_gia_hoat_dong(dto.getTham_gia_hoat_dong());
//        ExamDiscipline examDiscipline = ExamDiscipline.convertToEnum(dto.getKy_luat_thi());
//        e.setKy_luat_thi(examDiscipline);

		// 2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
//        e.setNop_nhan_kinh_phi(dto.getNop_nhan_kinh_phi());
//        e.setDang_ki_hoc_qua_han(dto.getDang_ki_hoc_qua_han());
//        e.setKhong_thuc_hien_yeu_cau(dto.getKhong_thuc_hien_yeu_cau());
//        e.setTra_qua_han_giay_to(dto.getTra_qua_han_giay_to());
//        e.setKhong_tham_gia_bao_hiem(dto.getKhong_tham_gia_bao_hiem());
		// private
		// 2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường

		e.setKhong_dong_hoc_phi(dto.getKhong_dong_hoc_phi());
		e.setVi_pham_quy_dinh_cu_tru(dto.getVi_pham_quy_dinh_cu_tru());
		e.setNghiem_tuc(dto.getNghiem_tuc());
		e.setKhong_hop_lop(dto.getKhong_hop_lop());
		e.setHoi_thao(dto.getHoi_thao());
		e.setVang_hoi_thao(dto.getVang_hoi_thao());
//        DisciplinaryDecision disciplinaryDecision = DisciplinaryDecision.convertToEnum(dto.getQuyet_dinh_ky_luat());
//        e.setQuyet_dinh_ky_luat(disciplinaryDecision);

		// 3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...

		e.setHien_mau(dto.getHien_mau());
		e.setTuyen_truyen(dto.getTuyen_truyen());
		e.setChong_ma_tuy(dto.getChong_ma_tuy());
		e.setSai_lech(dto.getSai_lech());

		e.setTham_gia_chi_doan_chinh_tri(dto.getTham_gia_chi_doan_chinh_tri());
		e.setTham_gia_hoat_dong(dto.getTham_gia_hoat_dong());
//        e.setKhong_tham_gia_sinh_hoat(dto.getKhong_tham_gia_sinh_hoat());
		// 4. về phẩm chất công dân và quan hệ với cộng đồng

		e.setChap_hanh_luat(dto.getChap_hanh_luat());
		e.setTuyen_truyen_dang(dto.getTuyen_truyen_dang());
		e.setQuan_he_dung_muc(dto.getQuan_he_dung_muc());
		e.setQuan_he_dung_tot(dto.getQuan_he_dung_tot());
		e.setKhen_cong_dong(dto.getKhen_cong_dong());
		e.setVi_pham_an_ninh(dto.getVi_pham_an_ninh());

//        e.setKhong_co_tinh_than_doan_ket(dto.getKhong_co_tinh_than_doan_ket());
		// 5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức
		// trong nhà trường, hoặc đạt
		// được thành tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên

		e.setTham_gia_clb(dto.getTham_gia_clb());

		e.setGiu_chuc_vu(dto.getGiu_chuc_vu());
		e.setHoc_luc_gioi_xuat_sac(dto.getHoc_luc_gioi_xuat_sac());
//        e.setChung_chi_tieng_Anh(dto.getChung_chi_tieng_Anh());
//        e.setTham_gia_cuoc_thi(dto.getTham_gia_cuoc_thi());
//        e.setDat_giai_cuoc_thi(dto.getDat_giai_cuoc_thi());
//        e.setTham_gia_NCKH(dto.getTham_gia_NCKH());
		e.setDat_giai_NCKH(dto.getDat_giai_NCKH());
//        e.setKet_nap_Dang(dto.getKet_nap_Dang());

		e.setTotalPoint(dto.autoGenerateTotalPoint());
	}
}
