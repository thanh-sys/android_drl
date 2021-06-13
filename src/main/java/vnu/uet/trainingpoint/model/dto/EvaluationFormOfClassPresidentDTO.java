package vnu.uet.trainingpoint.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vnu.uet.trainingpoint.model.DisciplinaryDecision;
import vnu.uet.trainingpoint.model.ExamDiscipline;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationFormOfClassPresidentDTO {

    private Boolean hoc_luc_yeu;

    private Boolean canh_cao_hoc_vu;

    private Boolean dang_ki_khong_du_tin;

    private Integer cam_thi_bo_thi;

    @Enumerated(EnumType.STRING)
    private ExamDiscipline ky_luat_thi;


    //    private
    //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
    private Integer nop_nhan_kinh_phi;

    private Boolean dang_ki_hoc_qua_han;

    private Integer khong_thuc_hien_yeu_cau;

    private Integer tra_qua_han_giay_to;

    private Boolean khong_tham_gia_bao_hiem;

    private Integer vi_pham_quy_dinh_cu_tru;

    @Enumerated(EnumType.STRING)
    private DisciplinaryDecision quyet_dinh_ky_luat;

    //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
    private Boolean tham_gia_chi_doan_chinh_tri;

    private Integer tham_gia_hoat_dong;

    private Integer khong_tham_gia_sinh_hoat;

    //4. về phẩm chất công dân và quan hệ với cộng đồng
    private Integer khong_chap_hanh_luat;

    private Integer khong_co_tinh_than_doan_ket;

    //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
    // đạt được tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
    private Boolean giu_chuc_vu;

    private Boolean hoc_luc_gioi_xuat_sac;

    private Boolean chung_chi_tieng_Anh;

    private Integer tham_gia_cuoc_thi;

    private Boolean dat_giai_cuoc_thi;

    private Boolean tham_gia_NCKH;

    private Boolean dat_giai_NCKH;

    private Boolean ket_nap_Dang;

    private Long totalPoint;
}
