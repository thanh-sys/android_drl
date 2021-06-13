package vnu.uet.trainingpoint.enitty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import vnu.uet.trainingpoint.model.DisciplinaryDecision;
import vnu.uet.trainingpoint.model.ExamDiscipline;
import vnu.uet.trainingpoint.model.Status;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EvaluationFormOfClassPresident {

    @Id
    @GeneratedValue
    private Long id;

    //1. Ý thức học tâp
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

    private Integer totalPoint;

    public Integer getTotal1(){
        Integer total1= 30;
//        Boolean hoc_luc_yeu;
        total1= hoc_luc_yeu? total1-3: total1;
//        Boolean canh_cao_hoc_vu;
        total1= canh_cao_hoc_vu? total1-5:total1;
//        Boolean dang_ki_khong_du_tin;
        total1=dang_ki_khong_du_tin? total1-5: total1;
//        Integer cam_thi_bo_thi;
        total1-= cam_thi_bo_thi*2;
//        String ky_luat_thi;  //enum
        switch (ky_luat_thi){
            case CANH_CAO:
                total1= total1/2;   // -50%
                break;
            case KHIEN_TRACH:
                total1= total1/4*3;  // -25%
                break;
            case DINH_CHI:
                total1= 0;

        }
        return total1;
    }

    public Integer getTotal2() {
        Integer total2=25;
//        //    private
//        //2. Ý thức và kết quả chấp hành nội quy, quy chế của nhà trường
//        Integer nop_nhan_kinh_phi;
        total2-= nop_nhan_kinh_phi*5;
//        Boolean dang_ki_hoc_qua_han;
        total2= dang_ki_hoc_qua_han? total2-2: total2;
//        Integer khong_thuc_hien_yeu_cau;
        total2-= 5*khong_thuc_hien_yeu_cau;
//        Integer tra_qua_han_giay_to;
        total2-= 5*tra_qua_han_giay_to;
//        Boolean khong_tham_gia_bao_hiem;
        total2= khong_tham_gia_bao_hiem? total2-5: total2;
//        Integer vi_pham_quy_dinh_cu_tru;
        total2-= vi_pham_quy_dinh_cu_tru*10;
//        String quyet_dinh_ky_luat;  // enum
        switch (quyet_dinh_ky_luat){
            case CANH_CAO:
                total2= 0;
                break;
            case PHE_BINH: // -50%
                total2= total2/2;
                break;
            case KHIEN_TRACH:
                total2= total2/4*3;
        }
        return total2;
    }

    public Integer getTotal3(){
        Integer total3=0;
//        //3. Ý thức và kết quả than gia haojt động chính trị- văn hóa, xã hội...
//        Boolean tham_gia_chi_doan_chinh_tri;
        total3= tham_gia_chi_doan_chinh_tri? total3+10: total3;
//        Integer tham_gia_hoat_dong;
        total3+= 2*tham_gia_hoat_dong;
//        Integer khong_tham_gia_sinh_hoat;
        total3-= khong_tham_gia_sinh_hoat*2;

        return total3;

    }

    public Integer getTotal4(){
        Integer total4=15;
        //        //4. về phẩm chất công dân và quan hệ với cộng đồng
//        Integer khong_chap_hanh_luat;
        total4-= khong_chap_hanh_luat*5;
//        Integer khong_co_tinh_than_doan_ket;
        total4-= khong_co_tinh_than_doan_ket*5;
        return total4;
    }

    public Integer getTotal5(){
        Integer total5 =0;
        //5. ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường, hoặc đạt
//        // đạt được tích đặc biệt trong học tập, rèn luyện của học sinh, sinh viên
//        Boolean giu_chuc_vu;
        total5=giu_chuc_vu? total5+10:total5;
//        Boolean hoc_luc_gioi_xuat_sac;
        total5= hoc_luc_gioi_xuat_sac? total5+10: total5;
//        Boolean chung_chi_tieng_Anh;
        total5= chung_chi_tieng_Anh? total5+5: total5;
//        Integer tham_gia_cuoc_thi;
        total5+= tham_gia_cuoc_thi*2;
//        Boolean dat_giai_cuoc_thi;
        total5= dat_giai_cuoc_thi?total5+5:total5;
//        Boolean tham_gia_NCKH;
        total5= tham_gia_NCKH? total5+5: total5;
//        Boolean dat_giai_NCKH;
        total5= dat_giai_NCKH? total5+5: total5;
//        Boolean ket_nap_Dang;
        total5= ket_nap_Dang?total5+10: total5;

        return total5;
    }

    public Integer autoGenerateTotalPoint(){
        Integer result= 0;
        result= getTotal1()+getTotal2()+getTotal3()+getTotal4()+getTotal5();
        if(result<0){
            result=0;
        }
        if(result>100){
            result=100;
        }
        return result;
    }


}
