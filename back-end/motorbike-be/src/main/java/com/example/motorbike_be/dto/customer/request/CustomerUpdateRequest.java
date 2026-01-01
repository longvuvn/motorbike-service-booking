package com.example.motorbike_be.dto.customer.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    @NotBlank(message = "Họ Và Tên không được để trống")
    private String fullName;
    @NotBlank(message = "Số điện thoại được không được để trống")
    private String phoneNumber;
    private String avatar;
    private String status;
}
