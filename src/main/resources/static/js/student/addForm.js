const BENCHMARK = 30;

function clickHocLucYeu(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "point")).html("-3");
        return -3;
    } else {
        $('#' + id.replace("input", "point")).html("0");
        return 0;
    }
}

function clickCanhBaoHocVu(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "point")).html("-5");
        return -5;
    } else {
        document.getElementById(id.replace("input", "point")).innerHTML = "0";
        return 0;
    }
}

function clickDangKiKhongDuTin(id) {
    if (document.getElementById(id).checked) {
        $('#' + id.replace("input", "point")).html("-5");
        return -5;
    } else {
        $('#' + id.replace("input", "point")).html("0");
        return 0;
    }
}

function fillCamThiBoThi(id) {
    // $('#' + id).on('change', function(){
    //     let number = document.getElementById(id).value * 2;
    //     $('#' + id.replace("input", "point")).html(number);
    //     return number;
    // });
    if (document.getElementById(id).onchange) {
        let number = document.getElementById(id).value * (-2);
        $('#' + id.replace("input", "point")).html(number);
        return number;
    }
}

function fillKyLuatThi(id) {
    if (document.getElementById(id).onchange) {
        if ($("#" + id).val() == "Khiển trách") {
            number = -BENCHMARK / 4;
            $('#' + id.replace("input", "point")).html(number);
            return number;
        }
        if ($("#" + id).val() == "Cảnh cáo") {
            number = -BENCHMARK / 2;
            $('#' + id.replace("input", "point")).html(number);
            return number;
        }
        if ($("#" + id).val() == "Đình chỉ") {
            number = -BENCHMARK;
            $('#' + id.replace("input", "point")).html(number);
            return number;
        }
        if ($("#" + id).val() == "Không") {
            number = 0;
            $('#' + id.replace("input", "point")).html(number);
            return number;
        }
    }
}

function totalPoint1(id) {
    let total = 0;
    console.log("here1");
    if (document.getElementById("pointHocLucYeu").onchange ||
        document.getElementById("pointCanhBaoHocVu").onchange ||
        document.getElementById("pointCanhBaoHocVu").onchange ||
        document.getElementById("pointCanhBaoHocVu").onchange ||
        document.getElementById("pointCanhBaoHocVu").onchange) {
        console.log("here2");
        total = clickHocLucYeu("inputHocLucYeu") +
            clickCanhBaoHocVu("inputCanhBaoHocVu") +
            clickDangKiKhongDuTin("inputCanhBaoHocVu") +
            fillCamThiBoThi("inputCanhBaoHocVu") +
            fillKyLuatThi("inputCanhBaoHocVu");
        console.log("here3");
    }
    console.log("here4");
    $('#' + id).html(total);
    console.log("here5");
} 


