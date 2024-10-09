package hcm.ptit.trainingpoint.model.dto;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import hcm.ptit.trainingpoint.enitty.EvaluationFormOfClassPresident;
import hcm.ptit.trainingpoint.model.DisciplinaryDecision;
import hcm.ptit.trainingpoint.model.ExamDiscipline;
import hcm.ptit.trainingpoint.model.Status;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class EvaluationFormDTO {

	private Long id;
	// 1. Ý thức học tâp
	private Boolean di_hoc_dung_gio;

	private Boolean hoc_luc_gioi;

	private Boolean hoc_luc_kha;

	private Boolean hoc_luc_trungbinh;

	private Boolean hoc_luc_duoi_trungbinh;

	private Boolean hoc_luc_yeu;

	private Integer cam_thi_bo_thi;

	private Integer canh_cao;

	private Integer khien_trach ;

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
//	private Boolean chung_chi_tieng_Anh;
//
//	private Integer tham_gia_cuoc_thi;
//
//	private Boolean dat_giai_cuoc_thi;
//
//	private Boolean tham_gia_NCKH;

	private Boolean dat_giai_NCKH;

//    private Status status;
	// điểm tổng
	private Integer totalPoint;

	public Integer getTotal1() {
		Integer total1 = 4;
		total1 = di_hoc_dung_gio ? total1 + 3 : total1;
		total1 = hoc_luc_gioi ? total1 + 8 : total1;
		total1 = hoc_luc_kha ? total1  + 6 : total1;
		total1 = hoc_luc_trungbinh ? total1 + 3 : total1;
		total1 = hoc_luc_duoi_trungbinh ? total1 - 0 : total1;
		total1 = vuot_kho ? total1 + 1 : total1;
		total1 = hoc_luc_gioi_xuat_sac ? total1 + 10 : total1;
		
		
//        Boolean hoc_luc_yeu;
		total1 = hoc_luc_yeu ? total1 - 1 : total1;
//        Boolean canh_cao_hoc_vu;
//		total1 = canh_cao_hoc_vu ? total1 - 5 : total1;
////        Boolean dang_ki_khong_du_tin;
//		total1 = dang_ki_khong_du_tin ? total1 - 5 : total1;
//        Integer cam_thi_bo_thi;

	
		total1 -= cam_thi_bo_thi * 2;
		
		total1 -= canh_cao * 3;
		total1 -= khien_trach * 2;
		total1 -= dinh_chi * 4;
		total1 += tham_gia_hoat_dong * 1;
		
//        String ky_luat_thi;  //enum
//        switch (ky_luat_thi){
//            case "CANH_CAO":
//                total1= total1/2;   // -50%
//                break;
//            case "KHIEN_TRACH":
//                total1= total1/4*3;  // -25%
//                break;
//            case "DINH_CHI":
//                total1= 0;
//
//        }
		return total1;
	}

	public Integer getTotal2() {
		Integer total2 = 15;
//        //    private
//        //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
//        Integer nop_nhan_kinh_phi;
//		total2 -= nop_nhan_kinh_phi * 5;
////        Boolean dang_ki_hoc_qua_han;
//		total2 = dang_ki_hoc_qua_han ? total2 - 2 : total2;
////        Integer khong_thuc_hien_yeu_cau;
//		total2 -= 5 * khong_thuc_hien_yeu_cau;
////        Integer tra_qua_han_giay_to;
//		total2 -= 5 * tra_qua_han_giay_to;
////        Boolean khong_tham_gia_bao_hiem;
//		total2 = khong_tham_gia_bao_hiem ? total2 - 5 : total2;
//        Integer vi_pham_quy_dinh_cu_tru;
		
		 
		total2 = khong_dong_hoc_phi ? total2 - 15 : total2;
		total2 = vi_pham_quy_dinh_cu_tru ? total2 - 5 : total2;
		total2 = nghiem_tuc ? total2 + 5 : total2;
		total2 = khong_hop_lop ? total2 - 1 : total2;
		total2 = hoi_thao ? total2 + 5 : total2;
		total2 = vang_hoi_thao ? total2 - 1 : total2;
//        String quyet_dinh_ky_luat;  // enum
//        switch (quyet_dinh_ky_luat){
//            case "CANH_CAO":
//                total2= 0;
//                break;
//            case "PHE_BINH": // -50%
//                total2= total2/2;
//                break;
//            case "KHIEN_TRACH":
//                total2= total2/4*3;
//        }
		return total2;
	}

	public Integer getTotal3() {
		Integer total3 = 0;
//        //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
//        Boolean tham_gia_chi_doan_chinh_tri;
		
		total3 += 2 * tham_gia_chi_doan_chinh_tri;
		total3 += 1 * hien_mau;
		total3 += 1 * tuyen_truyen;
		total3 = chong_ma_tuy ? total3 + 3 : total3;
		total3 = sai_lech ? total3 - 10 : total3;
//        Integer tham_gia_hoat_dong;
		
//        Integer khong_tham_gia_sinh_hoat;
//		total3 -= khong_tham_gia_sinh_hoat * 2;

		return total3;

	}

	public Integer getTotal4() {
		Integer total4 = 0;
		// //4. về phẩm chất công dân và quan hệ với cộng đồng
//        Integer khong_chap_hanh_luat;
		 
		total4 = chap_hanh_luat ? total4 + 8 : total4;
		total4 = tuyen_truyen_dang ? total4 + 5 : total4;
		total4 = quan_he_dung_muc ? total4 + 5 : total4;
		total4 = quan_he_dung_tot ? total4 + 5 : total4;
		total4 = khen_cong_dong ? total4 + 2 : total4;
		total4 = vi_pham_an_ninh ? total4 - 5 : total4;
		

//        Integer khong_co_tinh_than_doan_ket;
//		total4 -= khong_co_tinh_than_doan_ket * 5;
		return total4;
	}

	public Integer getTotal5() {
		Integer total5 = 0;
		// 5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức
		// trong nhà trường, hoặc đạt
//        // đạt được tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
//        Boolean giu_chuc_vu;
		 
		total5 = giu_chuc_vu ? total5 + 4 : total5;
		total5 = tham_gia_clb ? total5 + 3 : total5;
		 
		total5 = dat_giai_NCKH ? total5 + 3 : total5;
//        Boolean hoc_luc_gioi_xuat_sac;
		 
//        Boolean chung_chi_tieng_Anh;
//		total5 = chung_chi_tieng_Anh ? total5 + 5 : total5;
////        Integer tham_gia_cuoc_thi;
//		total5 += tham_gia_cuoc_thi * 2;
////        Boolean dat_giai_cuoc_thi;
//		total5 = dat_giai_cuoc_thi ? total5 + 5 : total5;
////        Boolean tham_gia_NCKH;
//		total5 = tham_gia_NCKH ? total5 + 5 : total5;
//        Boolean dat_giai_NCKH;
		 
//        Boolean ket_nap_Dang;
//		total5 = ket_nap_Dang ? total5 + 10 : total5;

		return total5;
	}

	public Integer autoGenerateTotalPoint() {
		Integer result = 0;
		result = getTotal1() + getTotal2() + getTotal3() + getTotal4() + getTotal5();
		if (result < 0) {
			result = 0;
		}
		if (result > 100) {
			result = 100;
		}
		return result;
	}

}
