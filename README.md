# traning_point
quy trình chấm điểm rèn luyện offline
văn phòng khoa -> lớp trưởng in phiếu tính điểm rèn luyện -> sinh viên điền phiếu -> đưa lại lớp trường duyệt -> đưa lên cố vấn học tập duyệt -> gửi lại văn phòng khoa-> thống kê nhập liệu

quy trình chấm điểm rèn luyện online
nhà trường tạo kỳ tính điểm rèn luyện ( import file cần thiết từ nhà trường: file điểm tổng kết, file thông tin về sing viên có tham gia các buổi mà nhà trường triệu tập hay không...)
-> sinh viên điền phiếu online( những gì trường import thì không cần điền, sẽ có những field theo default mà sinh viên cũng không phải điền nữa)
-> gửi cho lớp trưởng duyệt
-> gửi cố vấn học tập
-> gửi lên khoa


nhược điểm của quy trình chấm điểm offline: Sinh viên phải điền tất cả các field mà trường đã có trong DB của trường
sau đó nhà trường lại mất công check xem sinh viên có điền đúng không, lưu lại vào hệ thống
lớp trưởng phải đi thu từng bạn, kí offline 80 tờ giấy A4( nếu lớp có 80 sinh viên)/ kỳ
nếu sinh viên điền sai mà lớp trưởng phải cho điểm lại tốn rất nhiều thời gian và khó kiểm soát
cố vấn cũng tương tự
