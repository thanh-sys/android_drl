const BENCHMARK_1 = 4;
const BENCHMARK_2 = 15;
const BENCHMARK_3 = 0;
const BENCHMARK_4 = 0;
const BENCHMARK_5 = 0;



function isPositiveInteger(str) {
	var n = Math.floor(Number(str));
	if (n !== Infinity && String(n) === str && n >= 0) {
		return true;
	} else {
		return false;
	}
}

function clickAndMinusOne(id) {
	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("-1");
		return -3;
	} else {
		$('#' + id.replace("input", "evaluate")).html("0");
		return 0;
	}
}

function clickAndMinusTwo(id) {
	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("-2");
		return -2;
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

function clickAndMinusTen(id) {
	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("-10");
		return -10;
	} else {
		document.getElementById(id.replace("input", "evaluate")).innerHTML = "0";
		return 0;
	}
}

function clickAndMinus15(id) {
	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("-15");
		return -15;
	} else {
		document.getElementById(id.replace("input", "evaluate")).innerHTML = "0";
		return 0;
	}
}

function clickAndPlusZero(id) {
	if (id === 'inputHocLucDuoiTrungBinh') {
		document.getElementById('inputHocLuc').checked = false;
		$('#evaluateHocLuc').html("0");

		document.getElementById('inputHocLucGioi').checked = false;
		$('#evaluateHocLucGioi').html("0");

		document.getElementById('inputHocLucKha').checked = false;
		$('#evaluateHocLucKha').html("0");

		document.getElementById('inputHocLucTrungBinh').checked = false;
		$('#evaluateHocLucTrungBinh').html("0");

	}


	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("0");
		return -5;
	} else {
		$('#' + id.replace("input", "evaluate")).html("0");
		return 0;
	}
}

function clickAndPlusOne(id) {
	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("1");
		return -5;
	} else {
		$('#' + id.replace("input", "evaluate")).html("0");
		return 0;
	}
}

function clickAndPlusTwo(id) {
	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("2");
		return -5;
	} else {
		$('#' + id.replace("input", "evaluate")).html("0");
		return 0;
	}
}

function clickAndPlusThree(id) {


	if (id === 'inputHocLucTrungBinh') {
		document.getElementById('inputHocLuc').checked = false;
		$('#evaluateHocLuc').html("0");

		document.getElementById('inputHocLucGioi').checked = false;
		$('#evaluateHocLucGioi').html("0");

		document.getElementById('inputHocLucKha').checked = false;
		$('#evaluateHocLucKha').html("0");

		document.getElementById('inputHocLucDuoiTrungBinh').checked = false;
		$('#evaluateHocLucDuoiTrungBinh').html("0");
	}


	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("3");
		return -5;
	} else {
		$('#' + id.replace("input", "evaluate")).html("0");
		return 0;
	}
}

function clickAndPlusFour(id) {
	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("4");
		return -5;
	} else {
		$('#' + id.replace("input", "evaluate")).html("0");
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

function clickAndPlusSix(id) {

	if (id === 'inputHocLucKha') {
		document.getElementById('inputHocLuc').checked = false;
		$('#evaluateHocLuc').html("0");

		document.getElementById('inputHocLucGioi').checked = false;
		$('#evaluateHocLucGioi').html("0");

		document.getElementById('inputHocLucTrungBinh').checked = false;
		$('#evaluateHocLucTrungBinh').html("0");

		document.getElementById('inputHocLucDuoiTrungBinh').checked = false;
		$('#evaluateHocLucDuoiTrungBinh').html("0");
	}


	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("6");
		return -5;
	} else {
		$('#' + id.replace("input", "evaluate")).html("0");
		return 0;
	}
}

function clickAndPlusEight(id) {
	if (id === 'inputHocLucGioi') {
		document.getElementById('inputHocLuc').checked = false;
		$('#evaluateHocLuc').html("0");

		document.getElementById('inputHocLucKha').checked = false;
		$('#evaluateHocLucKha').html("0");

		document.getElementById('inputHocLucTrungBinh').checked = false;
		$('#evaluateHocLucTrungBinh').html("0");

		document.getElementById('inputHocLucDuoiTrungBinh').checked = false;
		$('#evaluateHocLucDuoiTrungBinh').html("0");
	}




	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("8");
		return -5;
	} else {
		$('#' + id.replace("input", "evaluate")).html("0");
		return 0;
	}
}

function clickAndPlusTen(id) {
	if (id === 'inputHocLuc') {
		document.getElementById('inputHocLucGioi').checked = false;
		$('#evaluateHocLucGioi').html("0");

		document.getElementById('inputHocLucKha').checked = false;
		$('#evaluateHocLucKha').html("0");

		document.getElementById('inputHocLucTrungBinh').checked = false;
		$('#evaluateHocLucTrungBinh').html("0");

		document.getElementById('inputHocLucDuoiTrungBinh').checked = false;
		$('#evaluateHocLucDuoiTrungBinh').html("0");
	}
	if (document.getElementById(id).checked) {
		$('#' + id.replace("input", "evaluate")).html("10");
		return -5;
	} else {
		$('#' + id.replace("input", "evaluate")).html("0");
		return 0;
	}
}

function plusOnePerTime(id) {
	if ($('#' + id).on('change')) {
		if (isPositiveInteger($('#' + id).val()) == true) {
			if (id === 'inputHienMau') {
				if (parseFloat($('#' + id).val().trim()) > 4) {
					$('#' + id.replace("input", "evaluate")).html(0);
					alert('Không được lớn hơn 4');
					return 0;
				}
			} else if (id === 'inputTuyenTruyen') {
				if (parseFloat($('#' + id).val().trim()) > 3) {
					$('#' + id.replace("input", "evaluate")).html(0);
					alert('Không được lớn hơn 3');
					return 0;
				}
			} else {
				if (parseFloat($('#' + id).val().trim()) > 2) {
					$('#' + id.replace("input", "evaluate")).html(0);
					alert('Không được lớn hơn 2');
					return 0;
				}
			}
			let number = $('#' + id).val() * 1;
			$('#' + id.replace("input", "evaluate")).html(number);
			return number;
		} else if ($('#' + id).val().trim() == '') {
			$('#' + id.replace("input", "evaluate")).html(0);
			alert('Bạn chưa điền ' + $('#' + id).attr("placeholder"));
		} else {
			$('#' + id.replace("input", "evaluate")).html(0);
			alert("Số lần phải > 0");
		}
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

function plusFourPerTime(id) {
	if ($('#' + id).on('change')) {
		if (isPositiveInteger($('#' + id).val()) == true) {
			let number = $('#' + id).val() * 4;
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

function minusThreePerTime(id) {
	if ($('#' + id).on('change')) {
		if (isPositiveInteger($('#' + id).val()) == true) {
			let number = $('#' + id).val() * (-3);
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

function minusFourPerTime(id) {
	if ($('#' + id).on('change')) {
		if (isPositiveInteger($('#' + id).val()) == true) {
			let number = $('#' + id).val() * (-4);
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

	let oldPointCamThiBoThi = parseInt($('#evaluateCamThiBoThi').text());
	if ($("#inputCamThiBoThi").on('change')) {
		total = total + oldPointCamThiBoThi;
	} else {
		total = total - oldPointCamThiBoThi;
	}


	let oldPointCanhCao = parseInt($('#evaluateCanhCao').text());
	if ($("#inputCanhCao").on('change')) {
		total = total + oldPointCanhCao;
	} else {
		total = total - oldPointCanhCao;
	}


	let oldPointKhienTrach = parseInt($('#evaluateKhienTrach').text());
	if ($("#inputKhienTrach").on('change')) {
		total = total + oldPointKhienTrach;
	} else {
		total = total - oldPointKhienTrach;
	}

	let oldPointDinhChi = parseInt($('#evaluateDinhChi').text());
	if ($("#inputDinhChi").on('change')) {
		total = total + oldPointDinhChi;
	} else {
		total = total - oldPointDinhChi;
	}

	$('#' + id).html(total);

}


function evaluateTotalPoint1(id) {
	let total = parseInt($('#evaluateTotal1').text());
	let oldPointDiHocDungGio = parseInt($('#evaluateDiHocDungGio').text());
	if (document.getElementById("inputDiHocDungGio").checked) {
		total = total + oldPointDiHocDungGio;
	} else {
		total = total - oldPointDiHocDungGio;
	}

	let oldPointHocLuc = parseInt($('#evaluateHocLuc').text());
	if (document.getElementById("inputHocLuc").checked) {
		total = total + oldPointHocLuc;
	} else {
		total = total - oldPointHocLuc;
	}

	let oldPointHocLucGioi = parseInt($('#evaluateHocLucGioi').text());
	if (document.getElementById("inputHocLucGioi").checked) {
		total = total + oldPointHocLucGioi;
	} else {
		total = total - oldPointHocLucGioi;
	}

	let oldPointHocLucKha = parseInt($('#evaluateHocLucKha').text());
	if (document.getElementById("inputHocLucKha").checked) {
		total = total + oldPointHocLucKha;
	} else {
		total = total - oldPointHocLucKha;
	}

	let oldPointHocLucTrungBinh = parseInt($('#evaluateHocLucTrungBinh').text());
	if (document.getElementById("inputHocLucTrungBinh").checked) {
		total = total + oldPointHocLucTrungBinh;
	} else {
		total = total - oldPointHocLucTrungBinh;
	}



	let oldPointHocLucYeu = parseInt($('#evaluateHocLucYeu').text());
	if (document.getElementById("inputHocLucYeu").checked) {
		total = total + oldPointHocLucYeu;
	} else {
		total = total - oldPointHocLucYeu;
	}

	let oldPointThamGiaHoatDong = parseInt($('#evaluateThamGiaHoatDong').text());
	if ($("#inputThamGiaHoatDong").on('change')) {
		total = total + oldPointThamGiaHoatDong;
	} else {
		total = total - oldPointThamGiaHoatDong;
	}

	let oldPointVuotKho = parseInt($('#evaluateVuotKho').text());
	if (document.getElementById("inputVuotKho").checked) {
		total = total + oldPointVuotKho;
	} else {
		total = total - oldPointVuotKho;
	}


	$('#' + id).html(total);
}

function evaluateTotal2(id) {
	let total = BENCHMARK_2;

	let oldPointKhongDongHocPhi = parseInt($('#evaluateKhongDongHocPhi').text());
	if (document.getElementById("inputKhongDongHocPhi").checked) {
		total = total + oldPointKhongDongHocPhi;
	} else {
		total = total - oldPointKhongDongHocPhi;
	}


	let oldPointViPhamCuTru = parseInt($('#evaluateViPhamCuTru').text());
	if (document.getElementById("inputViPhamCuTru").checked) {
		total = total + oldPointViPhamCuTru;
	} else {
		total = total - oldPointViPhamCuTru;
	}


	$('#' + id).html(total);
}

function evaluateTotalPoint2(id) {
	let total = parseInt($('#evaluateTotal2').text());

	let oldPointNghiemTuc = parseInt($('#evaluateNghiemTuc').text());
	if (document.getElementById("inputNghiemTuc").checked) {
		total = total + oldPointNghiemTuc;
	} else {
		total = total - oldPointNghiemTuc;
	}

	let oldPointKhongHopLop = parseInt($('#evaluateKhongHopLop').text());
	if (document.getElementById("inputKhongHopLop").checked) {
		total = total + oldPointKhongHopLop;
	} else {
		total = total - oldPointKhongHopLop;
	}

	let oldPointHoiThao = parseInt($('#evaluateHoiThao').text());
	if (document.getElementById("inputHoiThao").checked) {
		total = total + oldPointHoiThao;
	} else {
		total = total - oldPointHoiThao;
	}


	let oldPointVangHoiThao = parseInt($('#evaluateVangHoiThao').text());
	if (document.getElementById("inputVangHoiThao").checked) {
		total = total + oldPointVangHoiThao;
	} else {
		total = total - oldPointVangHoiThao;
	}
	$('#' + id).html(total);
}

function evaluateTotalPoint3(id) {
	let total = BENCHMARK_3;

	let oldPointThamGiaChinhTri = parseInt($('#evaluateThamGiaChinhTri').text());
	if ($("#inputThamGiaChinhTri").on('change')) {
		total = total + oldPointThamGiaChinhTri;
	} else {
		total = total - oldPointThamGiaChinhTri;
	}

	let oldPointHienMau = parseInt($('#evaluateHienMau').text());
	if ($("#inputHienMau").on('change')) {
		total = total + oldPointHienMau;
	} else {
		total = total - oldPointHienMau;
	}

	let oldPointTuyenTruyen = parseInt($('#evaluateTuyenTruyen').text());
	if ($("#inputTuyenTruyen").on('change')) {
		total = total + oldPointTuyenTruyen;
	} else {
		total = total - oldPointTuyenTruyen;
	}

	let oldPointChongMaTuy = parseInt($('#evaluateChongMaTuy').text());
	if ($("#inputChongMaTuy").on('change')) {
		total = total + oldPointChongMaTuy;
	} else {
		total = total - oldPointChongMaTuy;
	}

	let oldPointSaiLech = parseInt($('#evaluateSaiLech').text());
	if ($("#inputSaiLech").on('change')) {
		total = total + oldPointSaiLech;
	} else {
		total = total - oldPointSaiLech;
	}


	$('#' + id).html(total);
}

function evaluateTotalPoint4(id) {
	let total = BENCHMARK_4;


	let oldPointChapHanhLuat = parseInt($('#evaluateChapHanhLuat').text());
	if ($("#inputChapHanhLuat").on('change')) {
		total = total + oldPointChapHanhLuat;
	} else {
		total = total - oldPointChapHanhLuat;
	}

	let oldPointTuyenTruyenDang = parseInt($('#evaluateTuyenTruyenDang').text());
	if ($("#inputTuyenTruyenDang").on('change')) {
		total = total + oldPointTuyenTruyenDang;
	} else {
		total = total - oldPointTuyenTruyenDang;
	}

	let oldPointQuanHeDungMuc = parseInt($('#evaluateQuanHeDungMuc').text());
	if ($("#inputQuanHeDungMuc").on('change')) {
		total = total + oldPointQuanHeDungMuc;
	} else {
		total = total - oldPointQuanHeDungMuc;
	}

	let oldPointQuanHeDungTot = parseInt($('#evaluateQuanHeDungTot').text());
	if ($("#inputQuanHeDungTot").on('change')) {
		total = total + oldPointQuanHeDungTot;
	} else {
		total = total - oldPointQuanHeDungTot;
	}

	let oldPointKhenCongDong = parseInt($('#evaluateKhenCongDong').text());
	if ($("#inputKhenCongDong").on('change')) {
		total = total + oldPointKhenCongDong;
	} else {
		total = total - oldPointKhenCongDong;
	}

	let oldPointViPhamAnNinh = parseInt($('#evaluateViPhamAnNinh').text());
	if ($("#inputViPhamAnNinh").on('change')) {
		total = total + oldPointViPhamAnNinh;
	} else {
		total = total - oldPointViPhamAnNinh;
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

	let oldPointThamGiaCLB = parseInt($('#evaluateThamGiaCLB').text());
	if (document.getElementById("inputThamGiaCLB").checked) {
		total = total + oldPointThamGiaCLB;
	} else {
		total = total - oldPointThamGiaCLB;
	}

	let oldPointDatGiaiNCKH = parseInt($('#evaluateDatGiaiNCKH').text());
	if (document.getElementById("inputDatGiaiNCKH").checked) {
		total = total + oldPointDatGiaiNCKH;
	} else {
		total = total - oldPointDatGiaiNCKH;
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

function total1(id) {

	let total = BENCHMARK_1;

	let oldPointCamThiBoThi = parseInt($('#pointCamThiBoThi').text());
	total = total + oldPointCamThiBoThi;

	//	if ($("#inputCamThiBoThi").on('change')) {
	//		total = total + oldPointCamThiBoThi;
	//	} else {
	//		total = total - oldPointCamThiBoThi;
	//	}
	//
	//
	let oldPointCanhCao = parseInt($('#pointCanhCao').text());
	total = total + oldPointCanhCao;

	//	if ($("#inputCanhCao").on('change')) {
	//		total = total + oldPointCanhCao;
	//	} else {
	//		total = total - oldPointCanhCao;
	//	}
	//
	//
	let oldPointKhienTrach = parseInt($('#pointKhienTrach').text());
	total = total + oldPointKhienTrach;


	//	if ($("#inputKhienTrach").on('change')) {
	//		total = total + oldPointKhienTrach;
	//	} else {
	//		total = total - oldPointKhienTrach;
	//	}
	//
	let oldPointDinhChi = parseInt($('#pointDinhChi').text());
	total = total + oldPointDinhChi;
	//	if ($("#inputDinhChi").on('change')) {
	//		total = total + oldPointDinhChi;
	//	} else {
	//		total = total - oldPointDinhChi;
	//	}



	$('#' + id).html(total);

}

function totalPointFinal1(id) {
	let total = parseInt($('#total1').text());
	let oldPointDiHocDungGio = parseInt($('#pointDiHocDungGio').text());
	//	console.log("Dihocdunggiotext :" + oldPointDiHocDungGio);
	//console.log("Authority" + authority)
	//	if (document.getElementById("inputDiHocDungGio").checked) {
	//		total = total + oldPointDiHocDungGio;
	//	} else {
	//		total = total - oldPointDiHocDungGio;
	//	}
	total = total + oldPointDiHocDungGio;


	let oldPointHocLuc = parseInt($('#pointHocLuc').text());
	total = total + oldPointHocLuc;
	//	if (document.getElementById("inputHocLuc").checked) {
	//		total = total + oldPointHocLuc;
	//	} else {
	//		total = total - oldPointHocLuc;
	//	}

	let oldPointHocLucGioi = parseInt($('#pointHocLucGioi').text());
	total = total + oldPointHocLucGioi;


	//	if (document.getElementById("inputHocLucGioi").checked) {
	//		total = total + oldPointHocLucGioi;
	//	} else {
	//		total = total - oldPointHocLucGioi;
	//	}

	let oldPointHocLucKha = parseInt($('#pointHocLucKha').text());
	total = total + oldPointHocLucKha;


	//	if (document.getElementById("inputHocLucKha").checked) {
	//		total = total + oldPointHocLucKha;
	//	} else {
	//		total = total - oldPointHocLucKha;
	//	}

	let oldPointHocLucTrungBinh = parseInt($('#pointHocLucTrungBinh').text());
	total = total + oldPointHocLucTrungBinh;


	//	if (document.getElementById("inputHocLucTrungBinh").checked) {
	//		total = total + oldPointHocLucTrungBinh;
	//	} else {
	//		total = total - oldPointHocLucTrungBinh;
	//	}



	let oldPointHocLucYeu = parseInt($('#pointHocLucYeu').text());
	total = total + oldPointHocLucYeu;


	//	if (document.getElementById("inputHocLucYeu").checked) {
	//		total = total + oldPointHocLucYeu;
	//	} else {
	//		total = total - oldPointHocLucYeu;
	//	}
	//
	let oldPointThamGiaHoatDong = parseInt($('#pointThamGiaHoatDong').text());
	total = total + oldPointThamGiaHoatDong;

	//	if ($("#inputThamGiaHoatDong").on('change')) {
	//		total = total + oldPointThamGiaHoatDong;
	//	} else {
	//		total = total - oldPointThamGiaHoatDong;
	//	}

	let oldPointVuotKho = parseInt($('#pointVuotKho').text());
	total = total + oldPointVuotKho;
	//	if (document.getElementById("inputVuotKho").checked) {
	//		total = total + oldPointVuotKho;
	//	} else {
	//		total = total - oldPointVuotKho;
	//	}

	//    let oldPointCanhBaoHocVu = parseInt($('#pointCanhBaoHocVu').text());
	//    if (document.getElementById("inputCanhBaoHocVu").checked) {
	//        total = total + oldPointCanhBaoHocVu;
	//    } else {
	//        total = total - oldPointCanhBaoHocVu;
	//    }
	//
	//    let oldPointDangKiKhongDuTin = parseInt($('#pointDangKiKhongDuTin').text());
	//    if (document.getElementById("inputDangKiKhongDuTin").checked) {
	//        total = total + oldPointDangKiKhongDuTin;
	//    } else {
	//        total = total - oldPointDangKiKhongDuTin;
	//    }


	//	let totalFinal = parseInt($('#total1').text()) + total;

	$('#' + id).html(total);
}

function total2(id) {
	let total = BENCHMARK_2;

	let oldPointKhongDongHocPhi = parseInt($('#pointKhongDongHocPhi').text());
	total = total + oldPointKhongDongHocPhi;
	//	if (document.getElementById("inputKhongDongHocPhi").checked) {
	//		total = total + oldPointKhongDongHocPhi;
	//	} else {
	//		total = total - oldPointKhongDongHocPhi;
	//	}

	//	let oldPointNopNhanKinhPhi = parseInt($('#pointNopNhanKinhPhi').text());
	//	if ($("#inputNopNhanKinhPhi").on('change')) {
	//		total = total + oldPointNopNhanKinhPhi;
	//	} else {
	//		total = total - oldPointNopNhanKinhPhi;
	//	}
	//
	//	let oldPointDangKiHoc = parseInt($('#pointDangKiHoc').text());
	//	if (document.getElementById("inputDangKiHoc").checked) {
	//		total = total + oldPointDangKiHoc;
	//	} else {
	//		total = total - oldPointDangKiHoc;
	//	}
	//
	//	let oldPointKhongThucHienYeuCau = parseInt($('#pointKhongThucHienYeuCau').text());
	//	if ($("#inputKhongThucHienYeuCau").on('change')) {
	//		total = total + oldPointKhongThucHienYeuCau;
	//	} else {
	//		total = total - oldPointKhongThucHienYeuCau;
	//	}
	//
	//	let oldPointGiayToQuaHan = parseInt($('#pointGiayToQuaHan').text());
	//	if ($("#inputGiayToQuaHan").on('change')) {
	//		total = total + oldPointGiayToQuaHan;
	//	} else {
	//		total = total - oldPointGiayToQuaHan;
	//	}
	//
	//	let oldPointKhongBaoHiem = parseInt($('#pointKhongBaoHiem').text());
	//	if (document.getElementById("inputKhongBaoHiem").checked) {
	//		total = total + oldPointKhongBaoHiem;
	//	} else {
	//		total = total - oldPointKhongBaoHiem;
	//	}
	//

	let oldPointViPhamCuTru = parseInt($('#pointViPhamCuTru').text());
	total = total + oldPointViPhamCuTru;

	//	if (document.getElementById("inputViPhamCuTru").checked) {
	//		total = total + oldPointViPhamCuTru;
	//	} else {
	//		total = total - oldPointViPhamCuTru;
	//	}

	//	let oldPointViPhamCuTru = parseInt($('#pointViPhamCuTru').text());
	//	if ($("#inputViPhamCuTru").on('change')) {
	//		total = total + oldPointViPhamCuTru;
	//	} else {
	//		total = total - oldPointViPhamCuTru;
	//	}

	$('#' + id).html(total);
}

function totalPointFinal2(id) {
	let total = parseInt($('#total2').text());

	let oldPointNghiemTuc = parseInt($('#pointNghiemTuc').text());
	total = total + oldPointNghiemTuc;

	//	if (document.getElementById("inputNghiemTuc").checked) {
	//		total = total + oldPointNghiemTuc;
	//	} else {
	//		total = total - oldPointNghiemTuc;
	//	}

	let oldPointKhongHopLop = parseInt($('#pointKhongHopLop').text());
	total = total + oldPointKhongHopLop;

	//	if (document.getElementById("inputKhongHopLop").checked) {
	//		total = total + oldPointKhongHopLop;
	//	} else {
	//		total = total - oldPointKhongHopLop;
	//	}

	let oldPointHoiThao = parseInt($('#pointHoiThao').text());
	total = total + oldPointHoiThao;

	//	if (document.getElementById("inputHoiThao").checked) {
	//		total = total + oldPointHoiThao;
	//	} else {
	//		total = total - oldPointHoiThao;
	//	}


	let oldPointVangHoiThao = parseInt($('#pointVangHoiThao').text());
	total = total + oldPointVangHoiThao;
	//
	//	if (document.getElementById("inputVangHoiThao").checked) {
	//		total = total + oldPointVangHoiThao;
	//	} else {
	//		total = total - oldPointVangHoiThao;
	//	}
	//	let totalFinal = parseFloat($('#total2').text()) + parseFloat($('#pointQuyetDinhKyLuat').text().replace(",", "."));
	$('#' + id).html(total);
}

function totalPointFinal3(id) {
	let total = BENCHMARK_3;

	//	let oldPointThamGiaChinhTri = parseInt($('#pointThamGiaChinhTri').text());
	//	if (document.getElementById("inputThamGiaChinhTri").checked) {
	//		total = total + oldPointThamGiaChinhTri;
	//	} else {
	//		total = total - oldPointThamGiaChinhTri;
	//	}

	let oldPointThamGiaChinhTri = parseInt($('#pointThamGiaChinhTri').text());
	total = total + oldPointThamGiaChinhTri;
	//
	//	if ($("#inputThamGiaChinhTri").on('change')) {
	//		total = total + oldPointThamGiaChinhTri;
	//	} else {
	//		total = total - oldPointThamGiaChinhTri;
	//	}

	let oldPointHienMau = parseInt($('#pointHienMau').text());
	total = total + oldPointHienMau;

	//	if ($("#inputHienMau").on('change')) {
	//		total = total + oldPointHienMau;
	//	} else {
	//		total = total - oldPointHienMau;
	//	}

	let oldPointTuyenTruyen = parseInt($('#pointTuyenTruyen').text());
	total = total + oldPointTuyenTruyen;

	//	if ($("#inputTuyenTruyen").on('change')) {
	//		total = total + oldPointTuyenTruyen;
	//	} else {
	//		total = total - oldPointTuyenTruyen;
	//	}

	let oldPointChongMaTuy = parseInt($('#pointChongMaTuy').text());
	total = total + oldPointChongMaTuy;
	//
	//	if ($("#inputChongMaTuy").on('change')) {
	//		total = total + oldPointChongMaTuy;
	//	} else {
	//		total = total - oldPointChongMaTuy;
	//	}

	let oldPointSaiLech = parseInt($('#pointSaiLech').text());
	total = total + oldPointSaiLech;

	//	if ($("#inputSaiLech").on('change')) {
	//		total = total + oldPointSaiLech;
	//	} else {
	//		total = total - oldPointSaiLech;
	//	}

	//	let oldPointKhongThamGiaChinhTri = parseInt($('#pointKhongThamGiaChinhTri').text());
	//	if ($("#inputKhongThamGiaChinhTri").on('change')) {
	//		total = total + oldPointKhongThamGiaChinhTri;
	//	} else {
	//		total = total - oldPointKhongThamGiaChinhTri;
	//	}

	$('#' + id).html(total);
}

function totalPointFinal4(id) {
	let total = BENCHMARK_4;

	//	let oldPointKhongChapHanhLuat = parseInt($('#pointKhongChapHanhLuat').text());
	//	if ($("#inputKhongChapHanhLuat").on('change')) {
	//		total = total + oldPointKhongChapHanhLuat;
	//	} else {
	//		total = total - oldPointKhongChapHanhLuat;
	//	}

	let oldPointChapHanhLuat = parseInt($('#pointChapHanhLuat').text());
	total = total + oldPointChapHanhLuat;

//	if ($("#inputChapHanhLuat").on('change')) {
//		total = total + oldPointChapHanhLuat;
//	} else {
//		total = total - oldPointChapHanhLuat;
//	}

	let oldPointTuyenTruyenDang = parseInt($('#pointTuyenTruyenDang').text());
	total = total + oldPointTuyenTruyenDang;

//	if ($("#inputTuyenTruyenDang").on('change')) {
//		total = total + oldPointTuyenTruyenDang;
//	} else {
//		total = total - oldPointTuyenTruyenDang;
//	}

	let oldPointQuanHeDungMuc = parseInt($('#pointQuanHeDungMuc').text());
	total = total + oldPointQuanHeDungMuc;

//	if ($("#inputQuanHeDungMuc").on('change')) {
//		total = total + oldPointQuanHeDungMuc;
//	} else {
//		total = total - oldPointQuanHeDungMuc;
//	}

	let oldPointQuanHeDungTot = parseInt($('#pointQuanHeDungTot').text());
	total = total + oldPointQuanHeDungTot;

//	if ($("#inputQuanHeDungTot").on('change')) {
//		total = total + oldPointQuanHeDungTot;
//	} else {
//		total = total - oldPointQuanHeDungTot;
//	}

	let oldPointKhenCongDong = parseInt($('#pointKhenCongDong').text());
	total = total + oldPointKhenCongDong;

//	if ($("#inputKhenCongDong").on('change')) {
//		total = total + oldPointKhenCongDong;
//	} else {
//		total = total - oldPointKhenCongDong;
//	}

	let oldPointViPhamAnNinh = parseInt($('#pointViPhamAnNinh').text());
	total = total + oldPointViPhamAnNinh;

//	if ($("#inputViPhamAnNinh").on('change')) {
//		total = total + oldPointViPhamAnNinh;
//	} else {
//		total = total - oldPointViPhamAnNinh;
//	}

	//	let oldPointKhongDoanKet = parseInt($('#pointKhongDoanKet').text());
	//	if ($("#inputKhongDoanKet").on('change')) {
	//		total = total + oldPointKhongDoanKet;
	//	} else {
	//		total = total - oldPointKhongDoanKet;
	//	}

	$('#' + id).html(total);
}

function totalPointFinal5(id) {
	let total = BENCHMARK_5;

	let oldPointGiuChucVu = parseInt($('#pointGiuChucVu').text());
	total = total + oldPointGiuChucVu;

//	if (document.getElementById("inputGiuChucVu").checked) {
//		total = total + oldPointGiuChucVu;
//	} else {
//		total = total - oldPointGiuChucVu;
//	}

	let oldPointThamGiaCLB = parseInt($('#pointThamGiaCLB').text());
	total = total + oldPointThamGiaCLB;
//
//	if (document.getElementById("inputThamGiaCLB").checked) {
//		total = total + oldPointThamGiaCLB;
//	} else {
//		total = total - oldPointThamGiaCLB;
//	}

	//	let oldPointChungChiTiengAnh = parseInt($('#pointChungChiTiengAnh').text());
	//	if (document.getElementById("inputChungChiTiengAnh").checked) {
	//		total = total + oldPointChungChiTiengAnh;
	//	} else {
	//		total = total - oldPointChungChiTiengAnh;
	//	}
	//
	//	let oldPointThamGiaCuocThi = parseInt($('#pointThamGiaCuocThi').text());
	//	if ($("#inputThamGiaCuocThi").on('change')) {
	//		total = total + oldPointThamGiaCuocThi;
	//	} else {
	//		total = total - oldPointThamGiaCuocThi;
	//	}
	//
	//	let oldPointDatGiaiChuyenMon = parseInt($('#pointDatGiaiChuyenMon').text());
	//	if (document.getElementById("inputDatGiaiChuyenMon").checked) {
	//		total = total + oldPointDatGiaiChuyenMon;
	//	} else {
	//		total = total - oldPointDatGiaiChuyenMon;
	//	}
	//
	//	let oldPointThamGiaNCKH = parseInt($('#pointThamGiaNCKH').text());
	//	if (document.getElementById("inputThamGiaNCKH").checked) {
	//		total = total + oldPointThamGiaNCKH;
	//	} else {
	//		total = total - oldPointThamGiaNCKH;
	//	}

	let oldPointDatGiaiNCKH = parseInt($('#pointDatGiaiNCKH').text());
	total = total + oldPointDatGiaiNCKH;

//	if (document.getElementById("inputDatGiaiNCKH").checked) {
//		total = total + oldPointDatGiaiNCKH;
//	} else {
//		total = total - oldPointDatGiaiNCKH;
//	}

	//	let oldPointKetNapDang = parseInt($('#pointKetNapDang').text());
	//	if (document.getElementById("inputKetNapDang").checked) {
	//		total = total + oldPointKetNapDang;
	//	} else {
	//		total = total - oldPointKetNapDang;
	//	}	

	$('#' + id).html(total);
}

