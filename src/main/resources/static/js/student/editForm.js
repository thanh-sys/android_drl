const BENCHMARK_1 = 30;
const BENCHMARK_2 = 25;
const BENCHMARK_3 = 0;
const BENCHMARK_4 = 15;
const BENCHMARK_5 = 0;

function isPositiveInteger(str) {
    var n = Math.floor(Number(str));
    if (n !== Infinity && String(n) === str && n >= 0) {
        return true;
    } else {
        return false;
    }
}

function clickAndMinusTwo(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "evaluate")).html("-2");
        return -3;
    } else {
        $('#' + id.replace("input", "evaluate")).html("0");
        return 0;
    }
}

function clickAndMinusThree(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "evaluate")).html("-3");
        return -3;
    } else {
        $('#' + id.replace("input", "evaluate")).html("0");
        return 0;
    }
}

function clickAndMinusFive(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "evaluate")).html("-5");
        return -5;
    } else {
        document.getElementById(id.replace("input", "evaluate")).innerHTML = "0";
        return 0;
    }
}

function clickAndPlusFive(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "evaluate")).html("5");
        return -5;
    } else {
        $('#' + id.replace("input", "evaluate")).html("0");
        return 0;
    }
}

function clickAndPlusTen(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "evaluate")).html("10");
        return -5;
    } else {
        $('#' + id.replace("input", "evaluate")).html("0");
        return 0;
    }
}

function plusTwoPerTime(id) {
    if ($('#' + id).on('change')) {
        if (isPositiveInteger($('#' + id).val()) == true) {
            let number = $('#' + id).val() * 2;
            $('#' + id.replace("input", "evaluate")).html(number);
            return number;
        } else if ($('#' + id).val().trim() == '') {
            $('#' + id.replace("input", "evaluate")).html(0);
            alert('Bạn chưa điền ' + $('#' + id).attr("placeholder"));
        } else {
            alert("Số lần phải > 0");
        }
    }
}

function minusTwoPerTime(id) {
    if ($('#' + id).on('change')) {
        if (isPositiveInteger($('#' + id).val()) == true) {
            let number = $('#' + id).val() * (-2);
            $('#' + id.replace("input", "evaluate")).html(number);
            return number;
        } else if ($('#' + id).val().trim() == '') {
            $('#' + id.replace("input", "evaluate")).html(0);
            alert('Bạn chưa điền ' + $('#' + id).attr("placeholder"));
        } else {
            alert("Số lần phải > 0");
        }
    }
}

function minusFivePerTime(id) {
    if ($('#' + id).on('change')) {
        if (isPositiveInteger($('#' + id).val()) == true) {
            let number = $('#' + id).val() * (-5);
            $('#' + id.replace("input", "evaluate")).html(number);
            return number;
        } else if ($('#' + id).val().trim() == '') {
            $('#' + id.replace("input", "evaluate")).html(0);
            alert('Bạn chưa điền ' + $('#' + id).attr("placeholder"));
        } else {
            alert("Số lần phải > 0");
        }
    }
}

function minusTenPerTime(id) {
    if ($('#' + id).on('change')) {
        if (isPositiveInteger($('#' + id).val()) == true) {
            let number = $('#' + id).val() * (-10);
            $('#' + id.replace("input", "evaluate")).html(number);
            return number;
        } else if ($('#' + id).val().trim() == '') {
            $('#' + id.replace("input", "evaluate")).html(0);
            alert('Bạn chưa điền ' + $('#' + id).attr("placeholder"));
        } else {
            alert("Số lần phải > 0");
        }
    }
}

function evaluateTotal1(id) {
    let total = BENCHMARK_1;

    let oldPointHocLucYeu = parseInt($('#evaluateHocLucYeu').text());
    if (document.getElementById("inputHocLucYeu").checked) {
        total = total + oldPointHocLucYeu;
    } else {
        total = total - oldPointHocLucYeu;
    }

    let oldPointCanhBaoHocVu = parseInt($('#evaluateCanhBaoHocVu').text());
    if (document.getElementById("inputCanhBaoHocVu").checked) {
        total = total + oldPointCanhBaoHocVu;
    } else {
        total = total - oldPointCanhBaoHocVu;
    }

    let oldPointDangKiKhongDuTin = parseInt($('#evaluateDangKiKhongDuTin').text());
    if (document.getElementById("inputDangKiKhongDuTin").checked) {
        total = total + oldPointDangKiKhongDuTin;
    } else {
        total = total - oldPointDangKiKhongDuTin;
    }

    let oldPointCamThiBoThi = parseInt($('#evaluateCamThiBoThi').text());
    if ($("#inputCamThiBoThi").on('change')) {
        total = total + oldPointCamThiBoThi;
    } else {
        total = total - oldPointCamThiBoThi;
    }

    $('#' + id).html(total);
}

function fillKyLuatThi(id) {
    let total = parseInt($('#evaluateTotal1').text());
    if ($("#" + id).val() == "Khiển trách") {
        number = -total / 4;
        $('#' + id.replace("input", "evaluate")).html(number);
        return number;
    }
    if ($("#" + id).val() == "Cảnh cáo") {
        number = -total / 2;
        $('#' + id.replace("input", "evaluate")).html(number);
        return number;
    }
    if ($("#" + id).val() == "Đình chỉ") {
        number = -total;
        $('#' + id.replace("input", "evaluate")).html(number);
        return number;
    }
    if ($("#" + id).val() == "Không") {
        number = 0;
        $('#' + id.replace("input", "evaluate")).html(number);
        return number;
    }
}

function evaluateTotalPoint1(id) {
    let totalFinal = parseFloat($('#evaluateTotal1').text()) + parseFloat($('#evaluateKyLuatThi').text().replace(",", "."));
    $('#' + id).html(totalFinal);
}

function evaluateTotal2(id) {
    let total = BENCHMARK_2;

    let oldPointNopNhanKinhPhi = parseInt($('#evaluateNopNhanKinhPhi').text());
    if ($("#inputNopNhanKinhPhi").on('change')) {
        total = total + oldPointNopNhanKinhPhi;
    } else {
        total = total - oldPointNopNhanKinhPhi;
    }

    let oldPointDangKiHoc = parseInt($('#evaluateDangKiHoc').text());
    if (document.getElementById("inputDangKiHoc").checked) {
        total = total + oldPointDangKiHoc;
    } else {
        total = total - oldPointDangKiHoc;
    }

    let oldPointKhongThucHienYeuCau = parseInt($('#evaluateKhongThucHienYeuCau').text());
    if ($("#inputKhongThucHienYeuCau").on('change')) {
        total = total + oldPointKhongThucHienYeuCau;
    } else {
        total = total - oldPointKhongThucHienYeuCau;
    }

    let oldPointGiayToQuaHan = parseInt($('#evaluateGiayToQuaHan').text());
    if ($("#inputGiayToQuaHan").on('change')) {
        total = total + oldPointGiayToQuaHan;
    } else {
        total = total - oldPointGiayToQuaHan;
    }

    let oldPointKhongBaoHiem = parseInt($('#evaluateKhongBaoHiem').text());
    if (document.getElementById("inputKhongBaoHiem").checked) {
        total = total + oldPointKhongBaoHiem;
    } else {
        total = total - oldPointKhongBaoHiem;
    }

    let oldPointViPhamCuTru = parseInt($('#evaluateViPhamCuTru').text());
    if ($("#inputViPhamCuTru").on('change')) {
        total = total + oldPointViPhamCuTru;
    } else {
        total = total - oldPointViPhamCuTru;
    }

    console.log(total);
    $('#' + id).html(total);
}

function fillQuyetDinhKyLuat(id) {
    let total = parseInt($('#evaluateTotal2').text());
    if ($("#" + id).val() == "Cảnh cáo") {
        number = -total / 4;
        $('#' + id.replace("input", "evaluate")).html(number);
        return number;
    }
    if ($("#" + id).val() == "Khiển trách") {
        number = -total / 2;
        $('#' + id.replace("input", "evaluate")).html(number);
        return number;
    }
    if ($("#" + id).val() == "Phê bình") {
        number = -total;
        $('#' + id.replace("input", "evaluate")).html(number);
        return number;
    }
    if ($("#" + id).val() == "Không") {
        number = 0;
        $('#' + id.replace("input", "evaluate")).html(number);
        return number;
    }
}

function evaluateTotalPoint2(id) {
    let totalFinal = parseFloat($('#evaluateTotal2').text()) + parseFloat($('#evaluateQuyetDinhKyLuat').text().replace(",", "."));
    $('#' + id).html(totalFinal);
}

function evaluateTotalPoint3(id) {
    let total = BENCHMARK_3;

    let oldPointThamGiaChinhTri = parseInt($('#evaluateThamGiaChinhTri').text());
    if (document.getElementById("inputThamGiaChinhTri").checked) {
        total = total + oldPointThamGiaChinhTri;
    } else {
        total = total - oldPointThamGiaChinhTri;
    }

    let oldPointThamGiaHoatDong = parseInt($('#evaluateThamGiaHoatDong').text());
    if ($("#inputThamGiaHoatDong").on('change')) {
        total = total + oldPointThamGiaHoatDong;
    } else {
        total = total - oldPointThamGiaHoatDong;
    }

    let oldPointKhongThamGiaChinhTri = parseInt($('#evaluateKhongThamGiaChinhTri').text());
    if ($("#inputKhongThamGiaChinhTri").on('change')) {
        total = total + oldPointKhongThamGiaChinhTri;
    } else {
        total = total - oldPointKhongThamGiaChinhTri;
    }

    $('#' + id).html(total);
}

function evaluateTotalPoint4(id) {
    let total = BENCHMARK_4;

    let oldPointKhongChapHanhLuat = parseInt($('#evaluateKhongChapHanhLuat').text());
    if ($("#inputKhongChapHanhLuat").on('change')) {
        total = total + oldPointKhongChapHanhLuat;
    } else {
        total = total - oldPointKhongChapHanhLuat;
    }

    let oldPointKhongDoanKet = parseInt($('#evaluateKhongDoanKet').text());
    if ($("#inputKhongDoanKet").on('change')) {
        total = total + oldPointKhongDoanKet;
    } else {
        total = total - oldPointKhongDoanKet;
    }

    $('#' + id).html(total);
}

function evaluateTotalPoint5(id) {
    let total = BENCHMARK_5;

    let oldPointGiuChucVu = parseInt($('#evaluateGiuChucVu').text());
    if (document.getElementById("inputGiuChucVu").checked) {
        total = total + oldPointGiuChucVu;
    } else {
        total = total - oldPointGiuChucVu;
    }

    let oldPointHocLuc = parseInt($('#evaluateHocLuc').text());
    if (document.getElementById("inputHocLuc").checked) {
        total = total + oldPointHocLuc;
    } else {
        total = total - oldPointHocLuc;
    }

    let oldPointChungChiTiengAnh = parseInt($('#evaluateChungChiTiengAnh').text());
    if (document.getElementById("inputChungChiTiengAnh").checked) {
        total = total + oldPointChungChiTiengAnh;
    } else {
        total = total - oldPointChungChiTiengAnh;
    }

    let oldPointThamGiaCuocThi = parseInt($('#evaluateThamGiaCuocThi').text());
    if ($("#inputThamGiaCuocThi").on('change')) {
        total = total + oldPointThamGiaCuocThi;
    } else {
        total = total - oldPointThamGiaCuocThi;
    }

    let oldPointDatGiaiChuyenMon = parseInt($('#evaluateDatGiaiChuyenMon').text());
    if (document.getElementById("inputDatGiaiChuyenMon").checked) {
        total = total + oldPointDatGiaiChuyenMon;
    } else {
        total = total - oldPointDatGiaiChuyenMon;
    }

    let oldPointThamGiaNCKH = parseInt($('#evaluateThamGiaNCKH').text());
    if (document.getElementById("inputThamGiaNCKH").checked) {
        total = total + oldPointThamGiaNCKH;
    } else {
        total = total - oldPointThamGiaNCKH;
    }

    let oldPointDatGiaiNCKH = parseInt($('#evaluateDatGiaiNCKH').text());
    if (document.getElementById("inputDatGiaiNCKH").checked) {
        total = total + oldPointDatGiaiNCKH;
    } else {
        total = total - oldPointDatGiaiNCKH;
    }

    let oldPointKetNapDang = parseInt($('#evaluateKetNapDang').text());
    if (document.getElementById("inputKetNapDang").checked) {
        total = total + oldPointKetNapDang;
    } else {
        total = total - oldPointKetNapDang;
    }

    $('#' + id).html(total);
}

function evaluateTotalPoint(id) {
    let totalFinal = $('#totalPointFinalAlll').val();
    
    if (totalFinal >= 90) {
        $('#rank').html("Xuất sắc");
    } else if (totalFinal >= 80 && totalFinal < 90) {
        $('#rank').html("Tốt");
    } else if (totalFinal >= 65 && totalFinal < 80) {
        $('#rank').html("Khá");
    } else if (totalFinal >= 50 && totalFinal < 65) {
        $('#rank').html("Trung Bình");
    } else if (totalFinal >= 35 && totalFinal < 50) {
        $('#rank').html("Yếu");
    } else {
        $('#rank').html("Kém");
    }

    let evaluateTotalFinal = parseFloat($('#evaluateTotalPoint1').text().replace(",", ".")) + parseFloat($('#evaluateTotalPoint2').text().replace(",", ".")) + parseFloat($('#evaluateTotalPoint3').text()) + parseFloat($('#evaluateTotalPoint4').text()) + parseFloat($('#evaluateTotalPoint5').text());
    $('#' + id).val(evaluateTotalFinal);

    if (evaluateTotalFinal >= 90) {
        $('#evaluateRank').html("Xuất sắc");
    } else if (evaluateTotalFinal >= 80 && evaluateTotalFinal < 90) {
        $('#evaluateRank').html("Tốt");
    } else if (evaluateTotalFinal >= 65 && evaluateTotalFinal < 80) {
        $('#evaluateRank').html("Khá");
    } else if (evaluateTotalFinal >= 50 && evaluateTotalFinal < 65) {
        $('#evaluateRank').html("Trung Bình");
    } else if (evaluateTotalFinal >= 35 && evaluateTotalFinal < 50) {
        $('#evaluateRank').html("Yếu");
    } else {
        $('#evaluateRank').html("Kém");
    }
}