let searchInputID = ["studentIDFilter", "studentNameFilter", "evaluationRankFilter", "detailPointFilter", "formStatusFilter", "studentRoleFilter"]

$(document).ready(function () {
    $('.table.table-striped thead tr').clone(true).appendTo('.table.table-striped thead');
    $('.table.table-striped thead tr:eq(1) th').each(function (i) {
        var title = $(this).text();
        $(this).html('<input id=' + searchInputID[i] + ' type="text" placeholder="Tìm ' + title + '" />');

        $('input', this).on('keyup change', function () {
            if (table.column(i).search() !== this.value) {
                table.column(i).search(this.value).draw();
            }
        });
    });

    var table = $('.table.table-striped').DataTable({
        orderCellsTop: true,
        fixedHeader: true,
        stateSave: true
    });
});

$(document).ready(function() {
    // Lấy tất cả các phần tử chứa trạng thái của sinh viên
    let allApproved = true;
    $('#studentListListOfAdmin .formStatus').each(function() {
        if ($(this).text().trim() !== "Đã phê duyệt") {
            allApproved = false;
            return false; // Dừng vòng lặp nếu tìm thấy sinh viên không "Đã phê duyệt"
        }
    });

    // Nếu tất cả đều "Đã phê duyệt", enable nút
    if (allApproved) {
        $('#exportButton').css('pointer-events', 'auto');
        $('#exportButton').css('opacity', '1');
        $('#exportButton').removeClass('disabled-link');
    }
});