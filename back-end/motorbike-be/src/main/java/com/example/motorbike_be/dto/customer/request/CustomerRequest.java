package com.example.motorbike_be.dto.customer.request;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @NotBlank(message = "Họ Và Tên không được để trống")
    private String fullName;

    @NotBlank(message = "Username không được để trống")
    private String userName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.(com|vn)$", message = "Email phải kết thúc bằng .com hoặc .vn")
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống")
    @NotEmpty(message = "Thiếu mật khẩu")
    @Size(min = 8, message = "Mật khẩu có ít nhất 8 kí tự trở lên")
    private String password;

    @NotBlank(message = "Số điện thoại được không được để trống")
    private String phoneNumber;
}
