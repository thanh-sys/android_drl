'use strict';

let fileList = [
    {
        fileName: "Danh sách Sinh viên bị cảnh báo học vụ",
        semester: 1,
        schoolYear: "2020-2021"
    },
    {
        fileName: "Danh sách Sinh viên bị cảnh báo học vụ",
        semester: 2,
        schoolYear: "2020-2021"
    },
    {
        fileName: "Danh sách sinh viên bị cấm thi",
        semester: 1,
        schoolYear: "2019-2020"
    },
    {
        fileName: "Danh sách sinh viên bị cấm thi",
        semester: 2,
        schoolYear: "2019-2020"
    },
    {
        fileName: "Danh sách sinh viên không tham gia bảo hiểu Y Tế",
        semester: 1,
        schoolYear: "2018-2019"
    },
    {
        fileName: "Danh sách sinh viên không tham gia bảo hiểu Y Tế",
        semester: 1,
        schoolYear: "2018-2019"
    }
];

let fileNameList = ["Danh sách Sinh viên bị cảnh báo học vụ", "Danh sách sinh viên bị cấm thi", "Danh sách sinh viên không tham gia bảo hiểu Y Tế"];

for (let i = 0; i < fileList.length; i++) {
    let listItem =
        `<li>
            <a th:href="@{/#}" class="fileName">` + fileList[i].fileName + `</a>
            <div style="display: flex;">
                <label class="uploadLabel">Đợt:&nbsp;&nbsp;</label>
                <div class="uploadDate">Học kỳ ` + fileList[i].semester + ` - Năm học ` + fileList[i].schoolYear + `</div>
            </div>
        </li>`
    $('ul.list#oldNoticeList').append(listItem);
}
$("#searchNoticeFile").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("ul#oldNoticeList li").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
});


for (let i = 0; i < fileNameList.length; i++) {
    let listItem =
        `<li>
            <label for="uploadBlock" class="col-sm-6">` + fileNameList[i] + `</label>
            <div class="col-sm-4 uploadBlock">
                <input type="file" name="file-` + i + `[]" id="file-` + i + `" class="inputFile inputFile-` + i + `" data-multiple-caption="{count} files selected" multiple="">                                                    
                <label for="file-` + i + `" style="margin-bottom: 0px;">
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17">
                        <path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"></path>
                    </svg> 
                    <span>Chọn file để tải lên...</span>
                </label>
                <svg aria-hidden="true" focusable="false" width="20" height="20" data-prefix="fas" data-icon="check-square" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" class="svg-inline--fa fa-check-square fa-w-14 fa-2x">
                    <path fill="currentColor" d="M400 480H48c-26.51 0-48-21.49-48-48V80c0-26.51 21.49-48 48-48h352c26.51 0 48 21.49 48 48v352c0 26.51-21.49 48-48 48zm-204.686-98.059l184-184c6.248-6.248 6.248-16.379 0-22.627l-22.627-22.627c-6.248-6.248-16.379-6.249-22.628 0L184 302.745l-70.059-70.059c-6.248-6.248-16.379-6.248-22.628 0l-22.627 22.627c-6.248 6.248-6.248 16.379 0 22.627l104 104c6.249 6.25 16.379 6.25 22.628.001z" class="checkUpload"></path>
                </svg>
            </div>
            <button class="btn btn-success col-sm-2 submitUploadFile" type="submit" onclick="submitUploadFile(this)">Ghi nhận File</button>
        </li>`
    $('ul.list#newUploadList').append(listItem);
}
$("#searchFileName").on("keyup", function () {
    var value = $(this).val().toLowerCase();
    $("ul#newUploadList li").filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
});

;(function (document, window, index) {
    var inputs = document.querySelectorAll('.inputFile');
    Array.prototype.forEach.call(inputs, function (input) {
        console.log(input.files);
        var label = input.nextElementSibling,
            labelVal = label.innerHTML;

        input.addEventListener('change', function (e) {
            var fileName = '';
            if (this.files && this.files.length > 1) {
                fileName = (this.getAttribute('data-multiple-caption') || '').replace('{count}', this.files.length);
            } else {
                fileName = e.target.value.split('\\').pop();
            }

            if (fileName) {
                label.querySelector('span').innerHTML = fileName;
            } else {
                label.innerHTML = labelVal;
            }
        });
    });
}(document, window, 0));

// function submitUploadFile(buttonTag) {
//     $(buttonTag).parent().find('.uploadBlock .checkUpload').show();
// }