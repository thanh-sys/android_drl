str = $('#inputClass').val();
let schoolYear = str.substring(0, 7);
let className = str.substring(8);
$('#inputSchoolYear').val(schoolYear);
$('#inputClass').val(className);