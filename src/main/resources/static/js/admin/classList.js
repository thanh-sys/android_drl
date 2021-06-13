let searchInputID = ["classNameFilter", "schoolYearFilter", "studentListFilter"]

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
    $("#studentListFilter").remove();

    var table = $('.table.table-striped').DataTable({
        orderCellsTop: true,
        fixedHeader: true,
        stateSave: true
    });
});

$('#classListOfAdmin tr').each(function (index, tr) {
    str = $(tr).find('.className').text();
    let schoolYear = str.substring(0, 7);
    let className = str.substring(8);
    $(tr).find('.schoolYear').html(schoolYear);
    $(tr).find('.className').html(className);
});

function getDetailStudentList(linkTag) {
    let className = $(linkTag).parent().parent().find('td.className').text();
    let schoolYear = $(linkTag).parent().parent().find('td.schoolYear').text();
    $(linkTag).attr("href", "./studentList/" + schoolYear + "_" + className);
}