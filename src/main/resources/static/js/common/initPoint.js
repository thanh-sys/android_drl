//Di hoc dung gio
if ($('#inputDiHocDungGio').is(':checked') == true) {
//	$('#pointDiHocDungGio').html("3");
	$('#evaluateDiHocDungGio').html("3");
}

//Học lực Gioi
if ($('#inputHocLucGioi').is(':checked') == true) {
//	$('#pointHocLucGioi').html("8");
	$('#evaluateHocLucGioi').html("8");
}

//Học lực Kha
if ($('#inputHocLucKha').is(':checked') == true) {
//	$('#pointHocLucKha').html("6");
	$('#evaluateHocLucKha').html("6");
}

//Học lực TrungBinh
if ($('#inputHocLucTrungBinh').is(':checked') == true) {
//	$('#pointHocLucTrungBinh').html("3");
	$('#evaluateHocLucTrungBinh').html("3");
}
//Học lai
if ($('#inputHocLucYeu').is(':checked') == true) {
//	$('#pointHocLucYeu').html("-1");
	$('#evaluateHocLucYeu').html("-1");
}
////Bị cảnh báo học vụ
//if($('#inputCanhBaoHocVu').is(':checked')==true) {
//    $('#pointCanhBaoHocVu').html("-5");
//    $('#evaluateCanhBaoHocVu').html("-5");
//}
////Đăng ký không đủ số tín chỉ theo Quy định
//if($('#inputDangKiKhongDuTin').is(':checked')==true) {
//    $('#pointDangKiKhongDuTin').html("-5");
//    $('#evaluateDangKiKhongDuTin').html("-5");
//}

//Bị cấm thi hoặc bỏ thi cuối kỳ không có lý do
if ($('#inputCamThiBoThi').val() != null) {
	let number = $('#inputCamThiBoThi').val() * (-2);
//	$('#pointCamThiBoThi').html(number);
	$('#evaluateCamThiBoThi').html(number);
}

//Bị canh cao
if ($('#inputCanhCao').val() != null) {
	let number = $('#inputCanhCao').val() * (-3);
//	$('#pointCanhCao').html(number);
	$('#evaluateCanhCao').html(number);
}
//Bị khien trach
if ($('#inputKhienTrach').val() != null) {
	let number = $('#inputKhienTrach').val() * (-2);
//	$('#pointKhienTrach').html(number);
	$('#evaluateKhienTrach').html(number);
}

//Bị dinh chi
if ($('#inputDinhChi').val() != null) {
	let number = $('#inputDinhChi').val() * (-4);
//	$('#pointDinhChi').html(number);
	$('#evaluateDinhChi').html(number);
}

//vuot kho
if ($('#inputVuotKho').is(':checked') == true) {
//	$('#pointVuotKho').html("1");
	$('#evaluateVuotKho').html("1");
}
//Kỷ luật thi
// if( $('#inputKyLuatThi').val() != "NO" ) {
//     fillKyLuatThi('inputKyLuatThi');
// }
//Nộp hoặc nhận không đúng một khoản kinh phí
if ($('#inputNopNhanKinhPhi').val() != null) {
	let number = $('#inputNopNhanKinhPhi').val() * (-5);
//	$('#pointNopNhanKinhPhi').html(number);
	$('#evaluateNopNhanKinhPhi').html(number);
}
//Đăng kí học quá hạn
if ($('#inputDangKiHoc').is(':checked') == true) {
//	$('#pointDangKiHoc').html("-2");
	$('#evaluateDangKiHoc').html("-2");
}
//Không thực hiện theo Giấy triệu tập/Yêu cầu của Nhà trường
if ($('#inputKhongThucHienYeuCau').val() != null) {
	let number = $('#inputKhongThucHienYeuCau').val() * (-5);
//	$('#pointKhongThucHienYeuCau').html(number);
	$('#evaluateKhongThucHienYeuCau').html(number);
}
//Trả quá hạn giấy tờ/hồ sơ đã được phép mượn
if ($('#inputGiayToQuaHan').val() != null) {
	let number = $('#inputGiayToQuaHan').val() * (-5);
//	$('#pointGiayToQuaHan').html(number);
	$('#evaluateGiayToQuaHan').html(number);
}
////Không tham gia Bảo hiểm Y tế
//if ($('#inputKhongBaoHiem').is(':checked') == true) {
//	$('#pointKhongBaoHiem').html("-5");
//	$('#evaluateKhongBaoHiem').html("-5");
//}

//Vi phạm quy định nơi cư trú
if ($('#inputViPhamCuTru').is(':checked') == true) {
//	$('#pointViPhamCuTru').html("-5");
	$('#evaluateViPhamCuTru').html("-5");
}

//thuc hien nghiem tuc
if ($('#inputNghiemTuc').is(':checked') == true) {
//	$('#pointNghiemTuc').html("5");
	$('#evaluateNghiemTuc').html("5");
}
//khong hop lop
if ($('#inputKhongHopLop').is(':checked') == true) {
//	$('#pointKhongHopLop').html("-1");
	$('#evaluateKhongHopLop').html("-1");
}
//Hoi thao
if ($('#inputHoiThao').is(':checked') == true) {
//	$('#pointHoiThao').html("5");
	$('#evaluateHoiThao').html("5");
}
//khong hoi thao
if ($('#inputVangHoiThao').is(':checked') == true) {
//	$('#pointVangHoiThao').html("-1");
	$('#evaluateVangHoiThao').html("-1");
}
////Vi phạm quy định nơi cư trú
//if ($('#inputViPhamCuTru').val() != null) {
//	let number = $('#inputViPhamCuTru').val() * (-10);
//	$('#pointViPhamCuTru').html(number);
//	$('#evaluateViPhamCuTru').html(number);
//}
//Quyết định kỷ luật
// if( $('#inputQuyetDinhKyLuat').val() != "Không" ) {
//     fillQuyetDinhKyLuat('inputQuyetDinhKyLuat');
// }
////Tham gia đầy đủ các hoạt động của chi đoàn và tham gia đầy đủ các buổi sinh hoạt chính trị theo triệu tập (nếu có) của Nhà trường và tham gia đầy đủ các buổi sinh hoạt chính trị theo triệu tập (nếu có) của Nhà trường
//if ($('#inputThamGiaChinhTri').is(':checked') == true) {
//	$('#pointThamGiaChinhTri').html("10");
//	$('#evaluateThamGiaChinhTri').html("10");
//}

//Tham gia đầy đủ các hoạt động của chi đoàn và tham gia đầy đủ các buổi sinh hoạt chính trị theo triệu tập (nếu có) của Nhà trường và tham gia đầy đủ các buổi sinh hoạt chính trị theo triệu tập (nếu có) của Nhà trường
if ($('#inputThamGiaChinhTri').val() != null) {
	let number = $('#inputThamGiaChinhTri').val() * (2);
//	$('#pointThamGiaChinhTri').html(number);
	$('#evaluateThamGiaChinhTri').html(number);
}

//hienmau
if ($('#inputHienMau').val() != null) {
	let number = $('#inputHienMau').val() * (1);
//	$('#pointHienMau').html(number);
	$('#evaluateHienMau').html(number);
}

//TuyenTruyen
if ($('#inputTuyenTruyen').val() != null) {
	let number = $('#inputTuyenTruyen').val() * (1);
//	$('#pointTuyenTruyen').html(number);
	$('#evaluateTuyenTruyen').html(number);
}


//ChongMaTuy
if ($('#inputChongMaTuy').is(':checked') == true) {
//	$('#pointChongMaTuy').html("3");
	$('#evaluateChongMaTuy').html("3");
}

//SaiLech
if ($('#inputSaiLech').is(':checked') == true) {
//	$('#pointSaiLech').html("-10");
	$('#evaluateSaiLech').html("-10");
}


//Tham gia (có giấy xác nhận) các hoạt động văn nghệ, thể thao, câu lạc bộ, hoạt động tình nguyện, ...
if ($('#inputThamGiaHoatDong').val() != null) {
	let number = $('#inputThamGiaHoatDong').val() * (1);
//	$('#pointThamGiaHoatDong').html(number);
	$('#evaluateThamGiaHoatDong').html(number);
}
////Không tham gia Sinh hoạt chính trị theo Quy định
//if ($('#inputKhongThamGiaChinhTri').val() != null) {
//	let number = $('#inputKhongThamGiaChinhTri').val() * (-2);
//	$('#pointKhongThamGiaChinhTri').html(number);
//	$('#evaluateKhongThamGiaChinhTri').html(number);
//}
//Có Thông báo bằng văn bản về việc không chấp hành các chủ trương của Đảng, chính sách pháp luật của Nhà nước, vi phạm an ninh chính trị, trật tự an toàn xã hội, an toàn giao thông
if ($('#inputKhongChapHanhLuat').val() != null) {
	let number = $('#inputKhongChapHanhLuat').val() * (-5);
//	$('#pointKhongChapHanhLuat').html(number);
	$('#evaluateKhongChapHanhLuat').html(number);
}

////ChapHanhLuat
//if ($('#inputChapHanhLuat').val() != null) {
//	let number = $('#inputChapHanhLuat').val() * (8);
//	$('#pointChapHanhLuat').html(number);
//	$('#evaluateChapHanhLuat').html(number);
//}

//ChapHanhLuat
if ($('#inputChapHanhLuat').is(':checked') == true) {
//	$('#pointChapHanhLuat').html("8");
	$('#evaluateChapHanhLuat').html("8");
}

//TuyenTruyenDang
if ($('#inputTuyenTruyenDang').is(':checked') == true) {
//	$('#pointTuyenTruyenDang').html("5");
	$('#evaluateTuyenTruyenDang').html("5");
}

//QuanHeDungMuc
if ($('#inputQuanHeDungMuc').is(':checked') == true) {
//	$('#pointQuanHeDungMuc').html("5");
	$('#evaluateQuanHeDungMuc').html("5");
}

//QuanHeDungTot
if ($('#inputQuanHeDungTot').is(':checked') == true) {
//	$('#pointQuanHeDungTot').html("5");
	$('#evaluateQuanHeDungTot').html("5");
}

//KhenCongDong
if ($('#inputKhenCongDong').is(':checked') == true) {
//	$('#pointKhenCongDong').html("2");
	$('#evaluateKhenCongDong').html("2");
}

//ViPhamAnNinh
if ($('#inputViPhamAnNinh').is(':checked') == true) {
//	$('#pointViPhamAnNinh').html("-5");
	$('#evaluateViPhamAnNinh').html("-5");
}

//Không có tinh thần giúp đỡ bạn bè, không thể hiện tinh thần đoàn kết tập thể
if ($('#inputKhongDoanKet').val() != null) {
	let number = $('#inputKhongDoanKet').val() * (-5);
//	$('#pointKhongDoanKet').html(number);
	$('#evaluateKhongDoanKet').html(number);
}
//Giữ các chức vụ trong các tổ chức chính quyền, đoàn thể và được đánh giá hoàn thành tốt nhiệm vụ
if ($('#inputGiuChucVu').is(':checked') == true) {
//	$('#pointGiuChucVu').html("4");
	$('#evaluateGiuChucVu').html("4");
}
//Học lực (Xuất sắc, Giỏi)
if ($('#inputHocLuc').is(':checked') == true) {
//	$('#pointHocLuc').html("10");
	$('#evaluateHocLuc').html("10");
}

//Giữ các chức vụ trong các tổ chức chính quyền, đoàn thể và được đánh giá hoàn thành tốt nhiệm vụ
if ($('#inputThamGiaCLB').is(':checked') == true) {
//	$('#pointThamGiaCLB').html("3");
	$('#evaluateThamGiaCLB').html("3");
}
////Có chứng chỉ tiếng Anh vượt quy định
//if ($('#inputChungChiTiengAnh').is(':checked') == true) {
//	$('#pointChungChiTiengAnh').html("5");
//	$('#evaluateChungChiTiengAnh').html("5");
//}
////Tham gia các cuộc thi chuyên môn như Procon, Olympic, An toàn thông tin ...
//if ($('#inputThamGiaCuocThi').val() != null) {
//	let number = $('#inputThamGiaCuocThi').val() * (2);
//	$('#pointThamGiaCuocThi').html(number);
//	$('#evaluateThamGiaCuocThi').html(number);
//}


////Đạt giải tại các cuộc thi chuyên môn
//if ($('#inputDatGiaiChuyenMon').is(':checked') == true) {
//	$('#pointDatGiaiChuyenMon').html("5");
//	$('#evaluateDatGiaiChuyenMon').html("5");
//}
////Tham gia NCKH (không phải là SV NVCL)
//if ($('#inputThamGiaNCKH').is(':checked') == true) {
//	$('#pointThamGiaNCKH').html("5");
//	$('#evaluateThamGiaNCKH').html("5");
//}
//Đạt giải NCKH các cấp hoặc có báo cáo tại Hội nghị NCKH/bài báo đăng trên các tạp chí trong và ngoài nước
if ($('#inputDatGiaiNCKH').is(':checked') == true) {
//	$('#pointDatGiaiNCKH').html("3");
	$('#evaluateDatGiaiNCKH').html("3");
}
////Đươc kết nạp đảng
//if ($('#inputKetNapDang').is(':checked') == true) {
//	$('#pointKetNapDang').html("10");
//	$('#evaluateKetNapDang').html("10");
//}