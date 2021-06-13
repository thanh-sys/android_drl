const BENCHMARK_1 = 30;
const BENCHMARK_2 = 25;
const BENCHMARK_3 = 0;
const BENCHMARK_4 = 15;
const BENCHMARK_5 = 0;

function isPositiveInteger (str) {
    var n = Math.floor(Number(str));
    if (n !== Infinity && String(n) === str && n >= 0) {
        return true;
    } else {
        return false;
    }
}

function clickAndMinusTwo(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "point")).html("-2");
        return -3;
    } else {
        $('#' + id.replace("input", "point")).html("0");
        return 0;
    }
}

function clickAndMinusThree(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "point")).html("-3");
        return -3;
    } else {
        $('#' + id.replace("input", "point")).html("0");
        return 0;
    }
}

function clickAndMinusFive(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "point")).html("-5");
        return -5;
    } else {
        document.getElementById(id.replace("input", "point")).innerHTML = "0";
        return 0;
    }
}

function clickAndPlusFive(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "point")).html("5");
        return -5;
    } else {
        $('#' + id.replace("input", "point")).html("0");
        return 0;
    }
}

function clickAndPlusTen(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "point")).html("10");
        return -5;
    } else {
        $('#' + id.replace("input", "point")).html("0");
        return 0;
    }
}

function plusTwoPerTime(id) {
    if ($('#' + id).on('change')) {
        if (isPositiveInteger($('#' + id).val()) == true) {
            let number = $('#' + id).val() * 2;
            $('#' + id.replace("input", "point")).html(number);
            return number;
        } else if ($('#' + id).val().trim() == '') {
            $('#' + id.replace("input", "point")).html(0);
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
            $('#' + id.replace("input", "point")).html(number);
            return number;
        } else if ($('#' + id).val().trim() == '') {
            $('#' + id.replace("input", "point")).html(0);
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
            $('#' + id.replace("input", "point")).html(number);
            return number;
        } else if ($('#' + id).val().trim() == '') {
            $('#' + id.replace("input", "point")).html(0);
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
            $('#' + id.replace("input", "point")).html(number);
            return number;
        } else if ($('#' + id).val().trim() == '') {
            $('#' + id.replace("input", "point")).html(0);
            alert('Bạn chưa điền ' + $('#' + id).attr("placeholder"));
        } else {
            alert("Số lần phải > 0");
        }
    }
}

function total1(id) {
    let total = BENCHMARK_1;

    let oldPointHocLucYeu = parseInt($('#pointHocLucYeu').text());
    if (document.getElementById("inputHocLucYeu").checked) {
        total = total + oldPointHocLucYeu;
    } else {
        total = total - oldPointHocLucYeu;
    }

    let oldPointCanhBaoHocVu = parseInt($('#pointCanhBaoHocVu').text());
    if (document.getElementById("inputCanhBaoHocVu").checked) {
        total = total + oldPointCanhBaoHocVu;
    } else {
        total = total - oldPointCanhBaoHocVu;
    }

    let oldPointDangKiKhongDuTin = parseInt($('#pointDangKiKhongDuTin').text());
    if (document.getElementById("inputDangKiKhongDuTin").checked) {
        total = total + oldPointDangKiKhongDuTin;
    } else {
        total = total - oldPointDangKiKhongDuTin;
    }

    let oldPointCamThiBoThi = parseInt($('#pointCamThiBoThi').text());
    if ($("#inputCamThiBoThi").on('change')) {
        total = total + oldPointCamThiBoThi;
    } else {
        total = total - oldPointCamThiBoThi;
    }

    $('#' + id).html(total);
}

function fillKyLuatThi(id) {
    let total = parseInt($('#total1').text());
    if ($("#" + id).val() == "KHIEN_TRACH") {
        number = -total / 4;
        $('#' + id.replace("input", "point")).html(number);
        return number;
    }
    if ($("#" + id).val() == "CANH_CAO") {
        number = -total / 2;
        $('#' + id.replace("input", "point")).html(number);
        return number;
    }
    if ($("#" + id).val() == "DINH_CHI") {
        number = -total;
        $('#' + id.replace("input", "point")).html(number);
        return number;
    }
    if ($("#" + id).val() == "NO") {
        number = 0;
        $('#' + id.replace("input", "point")).html(number);
        return number;
    }
}

function totalPointFinal1(id) {
    let totalFinal = parseFloat($('#total1').text()) + parseFloat($('#pointKyLuatThi').text().replace(",", "."));
    $('#' + id).html(totalFinal);
}

function total2(id) {
    let total = BENCHMARK_2;

    let oldPointNopNhanKinhPhi = parseInt($('#pointNopNhanKinhPhi').text());
    if ($("#inputNopNhanKinhPhi").on('change')) {
        total = total + oldPointNopNhanKinhPhi;
    } else {
        total = total - oldPointNopNhanKinhPhi;
    }

    let oldPointDangKiHoc = parseInt($('#pointDangKiHoc').text());
    if (document.getElementById("inputDangKiHoc").checked) {
        total = total + oldPointDangKiHoc;
    } else {
        total = total - oldPointDangKiHoc;
    }

    let oldPointKhongThucHienYeuCau = parseInt($('#pointKhongThucHienYeuCau').text());
    if ($("#inputKhongThucHienYeuCau").on('change')) {
        total = total + oldPointKhongThucHienYeuCau;
    } else {
        total = total - oldPointKhongThucHienYeuCau;
    }

    let oldPointGiayToQuaHan = parseInt($('#pointGiayToQuaHan').text());
    if ($("#inputGiayToQuaHan").on('change')) {
        total = total + oldPointGiayToQuaHan;
    } else {
        total = total - oldPointGiayToQuaHan;
    }

    let oldPointKhongBaoHiem = parseInt($('#pointKhongBaoHiem').text());
    if (document.getElementById("inputKhongBaoHiem").checked) {
        total = total + oldPointKhongBaoHiem;
    } else {
        total = total - oldPointKhongBaoHiem;
    }

    let oldPointViPhamCuTru = parseInt($('#pointViPhamCuTru').text());
    if ($("#inputViPhamCuTru").on('change')) {
        total = total + oldPointViPhamCuTru;
    } else {
        total = total - oldPointViPhamCuTru;
    }

    $('#' + id).html(total);
}

function fillQuyetDinhKyLuat(id) {
    let total = parseInt($('#total2').text());
    if ($("#" + id).val() == "CANH_CAO") {
        number = -total / 4;
        $('#' + id.replace("input", "point")).html(number);
        return number;
    }
    if ($("#" + id).val() == "KHIEN_TRACH") {
        number = -total / 2;
        $('#' + id.replace("input", "point")).html(number);
        return number;
    }
    if ($("#" + id).val() == "PHE_BINH") {
        number = -total;
        $('#' + id.replace("input", "point")).html(number);
        return number;
    }
    if ($("#" + id).val() == "NO") {
        number = 0;
        $('#' + id.replace("input", "point")).html(number);
        return number;
    }
}

function totalPointFinal2(id) {
    let totalFinal = parseFloat($('#total2').text()) + parseFloat($('#pointQuyetDinhKyLuat').text().replace(",", "."));
    $('#' + id).html(totalFinal);
}

function totalPointFinal3(id) {
    let total = BENCHMARK_3;

    let oldPointThamGiaChinhTri = parseInt($('#pointThamGiaChinhTri').text());
    if (document.getElementById("inputThamGiaChinhTri").checked) {
        total = total + oldPointThamGiaChinhTri;
    } else {
        total = total - oldPointThamGiaChinhTri;
    }

    let oldPointThamGiaHoatDong = parseInt($('#pointThamGiaHoatDong').text());
    if ($("#inputThamGiaHoatDong").on('change')) {
        total = total + oldPointThamGiaHoatDong;
    } else {
        total = total - oldPointThamGiaHoatDong;
    }

    let oldPointKhongThamGiaChinhTri = parseInt($('#pointKhongThamGiaChinhTri').text());
    if ($("#inputKhongThamGiaChinhTri").on('change')) {
        total = total + oldPointKhongThamGiaChinhTri;
    } else {
        total = total - oldPointKhongThamGiaChinhTri;
    }

    $('#' + id).html(total);
}

function totalPointFinal4(id) {
    let total = BENCHMARK_4;

    let oldPointKhongChapHanhLuat = parseInt($('#pointKhongChapHanhLuat').text());
    if ($("#inputKhongChapHanhLuat").on('change')) {
        total = total + oldPointKhongChapHanhLuat;
    } else {
        total = total - oldPointKhongChapHanhLuat;
    }

    let oldPointKhongDoanKet = parseInt($('#pointKhongDoanKet').text());
    if ($("#inputKhongDoanKet").on('change')) {
        total = total + oldPointKhongDoanKet;
    } else {
        total = total - oldPointKhongDoanKet;
    }

    $('#' + id).html(total);
}

function totalPointFinal5(id) {
    let total = BENCHMARK_5;

    let oldPointGiuChucVu = parseInt($('#pointGiuChucVu').text());
    if (document.getElementById("inputGiuChucVu").checked) {
        total = total + oldPointGiuChucVu;
    } else {
        total = total - oldPointGiuChucVu;
    }

    let oldPointHocLuc = parseInt($('#pointHocLuc').text());
    if (document.getElementById("inputHocLuc").checked) {
        total = total + oldPointHocLuc;
    } else {
        total = total - oldPointHocLuc;
    }

    let oldPointChungChiTiengAnh = parseInt($('#pointChungChiTiengAnh').text());
    if (document.getElementById("inputChungChiTiengAnh").checked) {
        total = total + oldPointChungChiTiengAnh;
    } else {
        total = total - oldPointChungChiTiengAnh;
    }

    let oldPointThamGiaCuocThi = parseInt($('#pointThamGiaCuocThi').text());
    if ($("#inputThamGiaCuocThi").on('change')) {
        total = total + oldPointThamGiaCuocThi;
    } else {
        total = total - oldPointThamGiaCuocThi;
    }

    let oldPointDatGiaiChuyenMon = parseInt($('#pointDatGiaiChuyenMon').text());
    if (document.getElementById("inputDatGiaiChuyenMon").checked) {
        total = total + oldPointDatGiaiChuyenMon;
    } else {
        total = total - oldPointDatGiaiChuyenMon;
    }

    let oldPointThamGiaNCKH = parseInt($('#pointThamGiaNCKH').text());
    if (document.getElementById("inputThamGiaNCKH").checked) {
        total = total + oldPointThamGiaNCKH;
    } else {
        total = total - oldPointThamGiaNCKH;
    }

    let oldPointDatGiaiNCKH = parseInt($('#pointDatGiaiNCKH').text());
    if (document.getElementById("inputDatGiaiNCKH").checked) {
        total = total + oldPointDatGiaiNCKH;
    } else {
        total = total - oldPointDatGiaiNCKH;
    }

    let oldPointKetNapDang = parseInt($('#pointKetNapDang').text());
    if (document.getElementById("inputKetNapDang").checked) {
        total = total + oldPointKetNapDang;
    } else {
        total = total - oldPointKetNapDang;
    }

    $('#' + id).html(total);
}

function totalPoint(id) {
    let totalFinal = parseFloat($('#totalPointFinal1').text().replace(",", ".")) + parseFloat($('#totalPointFinal2').text().replace(",", ".")) + parseFloat($('#totalPointFinal3').text()) + parseFloat($('#totalPointFinal4').text()) + parseFloat($('#totalPointFinal5').text());
    $('#' + id).val(totalFinal);

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
}