# Kiểm thử tự động giao diện Web Railway

Dự án học thuật theo nhóm (Nhóm 05, năm 2025), sử dụng Java, Selenium WebDriver và TestNG để tự động hóa một số luồng trên ứng dụng Safe Railway phục vụ học tập.

## Phạm vi

- Đăng nhập và kiểm soát truy cập.
- Đăng ký tài khoản và thay đổi mật khẩu.
- Đặt vé, điều hướng từ trang lịch trình và hủy vé.
- Tổ chức mã theo các lớp Page Object và các lớp test TestNG.

Bộ tài liệu có 16 test case. Báo cáo chạy TestNG được lưu trong bài gốc ghi nhận 7 PASS và 9 FAIL. Các lỗi chủ yếu liên quan đến khác biệt nội dung thông báo kỳ vọng/thực tế; hai luồng reset mật khẩu bị dừng do lỗi mail/application. Đây là kết quả lịch sử của lần chạy ngày 20/11/2025, không phải kết quả kiểm thử lại hiện tại.

## Công nghệ

Java 11, Maven, Selenium Java 4.38.0, TestNG 7.11.0, Microsoft Edge.

## Lưu ý bảo mật

Bản portfolio sử dụng biến môi trường cho thông tin đăng nhập. Không commit tài khoản, mật khẩu, file .env thực tế hoặc thông tin cá nhân. Chỉ chạy trên hệ thống kiểm thử được cho phép.

## Phân biệt phạm vi API

File ZIP được cung cấp chứa mã Selenium UI automation và workbook test case, không chứa Postman collection, REST Assured hoặc mã kiểm thử API. Vì vậy README này không ghi API Testing như một phần deliverable của dự án này.