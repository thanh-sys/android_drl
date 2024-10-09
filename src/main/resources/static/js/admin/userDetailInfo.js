document.addEventListener('DOMContentLoaded', function() {
    // Lấy các phần tử input
    const activeCheckbox = document.querySelector('input[name="user.active"]');
    const passwordInput = document.querySelector('input[name="user.password"]');
    const saveButton = document.querySelector('button[type="submit"]');

    // Lắng nghe sự kiện thay đổi trên checkbox 'active'
    activeCheckbox.addEventListener('change', function() {
        console.log('Active status changed:', activeCheckbox.checked);
    });

    // Lắng nghe sự kiện thay đổi trên trường 'password'
    passwordInput.addEventListener('input', function() {
        console.log('Password changed:', passwordInput.value);
    });

    // Lắng nghe sự kiện click trên nút submit
    saveButton.addEventListener('click', function(event) {
        event.preventDefault(); // Ngăn chặn việc submit form để xử lý thông tin trước

        // Thu thập giá trị của các trường
        const isActive = activeCheckbox.checked;
        const password = passwordInput.value;

        // Hiển thị thông tin đã nhập
        console.log('Password:', password);
        console.log('Active status:', isActive);

        // Ví dụ: Gửi dữ liệu qua AJAX (nếu cần)
        // Gửi dữ liệu hoặc xử lý thêm ở đây
        alert('Đang lưu thông tin người dùng...');

        // Sau khi xử lý xong, bạn có thể submit form nếu cần
        // event.target.form.submit();
    });
});
