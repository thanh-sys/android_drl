let searchInputID = ["studentIdFilter", "studentNameFilter", "studentEmailFilter", "studentBirthdayFilter", "studentClassFilter", "studentSchoolYearFilter", "studentAddressFilter", "editButtonFilter"]

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
    $("#editButtonFilter").remove();

    var table = $('.table.table-striped').DataTable({
        orderCellsTop: true,
        fixedHeader: true,
        autoWidth: true,
        stateSave: true
    });
    $("#updateHeader").attr("class", "");
});

$('#studentInfoList tr').each(function (index, tr) {
    str = $(tr).find('.studentClass').text();
    let studentSchoolYear = str.substring(0, 7);
    let studentClass = str.substring(8);
    $(tr).find('.studentSchoolYear').html(studentSchoolYear);
    $(tr).find('.studentClass').html(studentClass);
});