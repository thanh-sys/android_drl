package hcm.ptit.trainingpoint.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import hcm.ptit.trainingpoint.model.DisciplinaryDecision;
import hcm.ptit.trainingpoint.model.ExamDiscipline;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationFormOfClassPresidentDTO {

	// 1. Ý thức học tâp
		private Boolean di_hoc_dung_gio;

		private Boolean hoc_luc_gioi;

		private Boolean hoc_luc_kha;

		private Boolean hoc_luc_trungbinh;

		private Boolean hoc_luc_duoi_trungbinh;

		private Boolean hoc_luc_yeu;

		private Integer cam_thi_bo_thi;

		private Integer canh_cao;

		private Integer khien_trach;

		private Integer dinh_chi;
		
		private Integer tham_gia_hoat_dong;

		private Boolean vuot_kho;
		// private
		// 2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
		private Boolean khong_dong_hoc_phi;

		private Boolean vi_pham_quy_dinh_cu_tru;

		private Boolean nghiem_tuc;

		private Boolean khong_hop_lop;

		private Boolean hoi_thao;

		private Boolean vang_hoi_thao;

		// 3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
		private Integer tham_gia_chi_doan_chinh_tri;

		private Integer hien_mau;

		private Integer tuyen_truyen;

		private Boolean chong_ma_tuy;

		private Boolean sai_lech;

		
		// 4. về phẩm chất công dân và quan hệ với cộng đồng
		private Boolean chap_hanh_luat;

		private Boolean tuyen_truyen_dang;

		private Boolean quan_he_dung_muc;

		private Boolean quan_he_dung_tot;

		private Boolean khen_cong_dong;

		private Boolean vi_pham_an_ninh;
		// 5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức
		// trong nhà trường, hoặc đạt
		// đạt được tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
		private Boolean giu_chuc_vu;

		private Boolean tham_gia_clb;
		private Boolean hoc_luc_gioi_xuat_sac;
	//
//		private Boolean chung_chi_tieng_Anh;
	//
//		private Integer tham_gia_cuoc_thi;
	//
//		private Boolean dat_giai_cuoc_thi;
	//
//		private Boolean tham_gia_NCKH;

		private Boolean dat_giai_NCKH;


    private Long totalPoint;
}
