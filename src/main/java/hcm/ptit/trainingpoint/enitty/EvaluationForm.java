package hcm.ptit.trainingpoint.enitty;

import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

import hcm.ptit.trainingpoint.model.DisciplinaryDecision;
import hcm.ptit.trainingpoint.model.ExamDiscipline;
import hcm.ptit.trainingpoint.model.Status;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EvaluationForm {

	@Id
	@GeneratedValue
	private Long id;

	// 1. Ý thức học tâp
	private Boolean di_hoc_dung_gio;
	
	private Boolean hoc_luc_gioi_xuat_sac;

	private Boolean hoc_luc_gioi;

	private Boolean hoc_luc_kha;

	private Boolean hoc_luc_trungbinh;

	private Boolean hoc_luc_duoi_trungbinh;

	private Boolean hoc_luc_yeu;

//    private Boolean canh_cao_hoc_vu;
//
//    private Boolean dang_ki_khong_du_tin;

	private Integer cam_thi_bo_thi;

	private Integer canh_cao ;

	private Integer khien_trach;

	private Integer dinh_chi;
	
	private Integer tham_gia_hoat_dong;

	private Boolean vuot_kho;

//	@Enumerated(EnumType.STRING)
//	private ExamDiscipline ky_luat_thi;

	// private
	// 2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
//    private Integer nop_nhan_kinh_phi;
//
//    private Boolean dang_ki_hoc_qua_han;
//
//    private Integer khong_thuc_hien_yeu_cau;
//
//    private Integer tra_qua_han_giay_to;
//
//    private Boolean khong_tham_gia_bao_hiem;
	private Boolean khong_dong_hoc_phi;

	private Boolean vi_pham_quy_dinh_cu_tru;

	private Boolean nghiem_tuc;

	private Boolean khong_hop_lop;

	private Boolean hoi_thao;

	private Boolean vang_hoi_thao;
//	@Enumerated(EnumType.STRING)
//	private DisciplinaryDecision quyet_dinh_ky_luat;

	// 3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
	private Integer tham_gia_chi_doan_chinh_tri;
	
	private Integer hien_mau;
	
	private Integer tuyen_truyen;
	
	private Boolean chong_ma_tuy;
	
	private Boolean sai_lech;



//	private Integer khong_tham_gia_sinh_hoat;

	// 4. về phẩm chất công dân và quan hệ với cộng đồng
	private Boolean chap_hanh_luat;
	
	private Boolean tuyen_truyen_dang;
	
	private Boolean quan_he_dung_muc;
	
	private Boolean quan_he_dung_tot;
	
	private Boolean khen_cong_dong;
	
	private Boolean vi_pham_an_ninh;
	
//	private Integer khong_co_tinh_than_doan_ket;

	// 5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức
	// trong nhà trường, hoặc đạt
	// đạt được tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
	private Boolean giu_chuc_vu;

	private Boolean tham_gia_clb;
	
//
//	private Boolean chung_chi_tieng_Anh;
//
//	private Integer tham_gia_cuoc_thi;
//
//	private Boolean dat_giai_cuoc_thi;
//
//	private Boolean tham_gia_NCKH;

	private Boolean dat_giai_NCKH;

//	private Boolean ket_nap_Dang;

	@Enumerated(EnumType.STRING)
	@NonNull
	private Status status;

	// điểm tổng
	private Integer totalPoint;

	@ManyToOne
	@JoinColumn // default create fk student_id
	private Student student;

	@OneToOne
	@JoinColumn // default create FK EvaluationFormOfClassPresidentId;
	private EvaluationFormOfClassPresident evaluationFormOfClassPresident;

	@ManyToOne
	@JoinColumn
	private Semester semester; // default create semester_id
	
	@OneToOne
	@JoinColumn 
	private StudentQuestion studentQuestion;
	
	public String getYear() {
		int startYear = semester.getSemesterNo() / 3 + 1956;
		int endYear = startYear + 1;
		return startYear + " - " + endYear;
	}

	public String getSemesterInYear() { 
		return semester.getSemesterNo() % 3 == 1 ? "I" : "II";
	}

	public String getGraded() {
		String graded;
		if (totalPoint >= 90) {
			graded = "Xuất sắc";
		} else if (totalPoint >= 80 && totalPoint < 90) {
			graded = "Giỏi";
		} else if (totalPoint >= 65 && totalPoint < 80) {
			graded = "Khá";
		} else if (totalPoint >= 50 && totalPoint < 65) {
			graded = "Trung Bình";
		} else if (totalPoint >= 35 && totalPoint < 50) {
			graded = "Yếu";
		} else {
			graded = "Kém";
		}
		return graded;
	}

	public String getPosition() {
		String position;
		if (this.getStudent().getUser().getRoles().equals("ROLE_STUDENT")) {
			position = "Sinh viên";
		} else {
			position = "Lớp trưởng";
		}
		return position;
	}

	public Integer getTotal1() {
		Integer total1 = 4;
//        Boolean hoc_luc_yeu;
		total1 = di_hoc_dung_gio ? total1 + 3 : total1;
		
		total1 = hoc_luc_gioi_xuat_sac ? total1 + 10 : total1;
		total1 = hoc_luc_gioi ? total1 + 8 : total1;
		total1 = hoc_luc_trungbinh ? total1 + 3 : total1;
		total1 = hoc_luc_kha ? total1 + 6 : total1;
		total1 = hoc_luc_yeu ? total1 - 1 : total1;
//        Boolean canh_cao_hoc_vu;
//		total1 = canh_cao_hoc_vu ? total1 - 5 : total1;
////        Boolean dang_ki_khong_du_tin;
//		total1 = dang_ki_khong_du_tin ? total1 - 5 : total1;
//        Integer cam_thi_bo_thi;
		total1 -= cam_thi_bo_thi * 2;
		
		total1 -= khien_trach * 2;
		
		total1 -= canh_cao * 3;
		
		total1 -= dinh_chi * 4;
		
		total1 += tham_gia_hoat_dong * 1;
		
		total1 = vuot_kho ? total1 + 1 : total1;
//        String ky_luat_thi;  //enum
//		switch (ky_luat_thi) {
//		case CANH_CAO:
//			total1 = total1 / 2; // -50%
//			break;
//		case KHIEN_TRACH:
//			total1 = total1 / 4 * 3; // -25%
//			break;
//		case DINH_CHI:
//			total1 = 0;

//		}
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
//		total2 += 1 * hoi_thao;
		
		total2 = vang_hoi_thao ? total2 - 1 : total2;
//        String quyet_dinh_ky_luat;  // enum
//		switch (quyet_dinh_ky_luat) {
//		case CANH_CAO:
//			total2 = 0;
//			break;
//		case PHE_BINH: // -50%
//			total2 = total2 / 2;
//			break;
//		case KHIEN_TRACH:
//			total2 = total2 / 4 * 3;
//		}
		return total2;
	}

	public Integer getTotal3() {
		Integer total3 = 0;
//        //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
//        Boolean tham_gia_chi_doan_chinh_tri;
	
		total3 += 2 * tham_gia_chi_doan_chinh_tri;
		
		total3 += 1 * hien_mau;
//        Integer tham_gia_hoat_dong;
		total3 += 1 * tuyen_truyen;
//        Integer khong_tham_gia_sinh_hoat;
//		total3 -= khong_tham_gia_sinh_hoat * 2;

		total3 = chong_ma_tuy ? total3 + 3 : total3;
		
		total3 = sai_lech ? total3 - 10 : total3;
		
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
//        Boolean ket_nap_Dang;
//		total5 = ket_nap_Dang ? total5 + 10 : total5;

		return total5;
	}

	public boolean getStatusNeedFill() {
		if (this.status.equals(Status.NEED_STUDENT_FILL)) {
			return true;
		}
		return false;
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

	@Override
	public String toString() {
//		return "EvaluationForm{" + "id=" + id + ", hoc_luc_yeu=" + hoc_luc_yeu + ", canh_cao_hoc_vu=" + canh_cao_hoc_vu
//				+ ", dang_ki_khong_du_tin=" + dang_ki_khong_du_tin + ", cam_thi_bo_thi=" + cam_thi_bo_thi
//				+ ", ky_luat_thi=" + ky_luat_thi + ", nop_nhan_kinh_phi=" + nop_nhan_kinh_phi + ", dang_ki_hoc_qua_han="
//				+ dang_ki_hoc_qua_han + ", khong_thuc_hien_yeu_cau=" + khong_thuc_hien_yeu_cau
//				+ ", tra_qua_han_giay_to=" + tra_qua_han_giay_to + ", khong_tham_gia_bao_hiem="
//				+ khong_tham_gia_bao_hiem + ", vi_pham_quy_dinh_cu_tru=" + vi_pham_quy_dinh_cu_tru
//				+ ", quyet_dinh_ky_luat=" + quyet_dinh_ky_luat + ", tham_gia_chi_doan_chinh_tri="
//				+ tham_gia_chi_doan_chinh_tri + ", tham_gia_hoat_dong=" + tham_gia_hoat_dong
//				+ ", khong_tham_gia_sinh_hoat=" + khong_tham_gia_sinh_hoat + ", khong_chap_hanh_luat="
//				+ khong_chap_hanh_luat + ", khong_co_tinh_than_doan_ket=" + khong_co_tinh_than_doan_ket
//				+ ", giu_chuc_vu=" + giu_chuc_vu + ", hoc_luc_gioi_xuat_sac=" + hoc_luc_gioi_xuat_sac
//				+ ", chung_chi_tieng_Anh=" + chung_chi_tieng_Anh + ", tham_gia_cuoc_thi=" + tham_gia_cuoc_thi
//				+ ", dat_giai_cuoc_thi=" + dat_giai_cuoc_thi + ", tham_gia_NCKH=" + tham_gia_NCKH + ", dat_giai_NCKH="
//				+ dat_giai_NCKH + ", ket_nap_Dang=" + ket_nap_Dang + ", status=" + status + ", totalPoint=" + totalPoint
//				+ ", student=" + student + ", evaluationFormOfClassPresident=" + evaluationFormOfClassPresident
//				+ ", semester=" + semester + '}';
		return "EvaluationForm{" + "id=" + id + ", di hoc dung gio=" + di_hoc_dung_gio + ", canh_cao_hoc_vu="
				+ ", dang_ki_khong_du_tin=" + ", cam_thi_bo_thi=" + cam_thi_bo_thi + ", ky_luat_thi="
				+ ", nop_nhan_kinh_phi=" + ", dang_ki_hoc_qua_han=" + ", khong_thuc_hien_yeu_cau="
				+ ", tra_qua_han_giay_to=" + ", khong_tham_gia_bao_hiem=" + ", vi_pham_quy_dinh_cu_tru="
				+ vi_pham_quy_dinh_cu_tru + ", quyet_dinh_ky_luat=" + ", tham_gia_chi_doan_chinh_tri="
				+ tham_gia_chi_doan_chinh_tri + ", tham_gia_hoat_dong=" + tham_gia_hoat_dong
				+ ", khong_tham_gia_sinh_hoat="  + ", khong_chap_hanh_luat="
				+  chap_hanh_luat + ", khong_co_tinh_than_doan_ket=" 
				+ ", giu_chuc_vu=" + giu_chuc_vu + ", hoc_luc_gioi_xuat_sac=" + hoc_luc_gioi_xuat_sac
				+ ", chung_chi_tieng_Anh="  + ", tham_gia_cuoc_thi=" 
				+ ", dat_giai_cuoc_thi="  + ", tham_gia_NCKH="  + ", dat_giai_NCKH="
				+ dat_giai_NCKH + ", ket_nap_Dang="  + ", status=" + status + ", totalPoint=" + totalPoint
				+ ", student=" + student + ", evaluationFormOfClassPresident=" + evaluationFormOfClassPresident
				+ ", semester=" + semester + '}';

	}
}
