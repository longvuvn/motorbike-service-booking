package com.example.motorbike_be.dto.address.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    @NotBlank(message = "Họ và tên không được để trống")
    @NotEmpty(message = "Thiếu Họ Và Tên")
    private String fullName;

    @NotEmpty(message = "Thiếu số điện thoại")
    @NotBlank(message = "Số điện thoại không được để trống")
    private String phoneNumber;

    @NotBlank(message = "Địa chỉ cụ thể không để trống")
    @NotEmpty(message = "Thiếu địa chỉ cụ thể")
    private String addressDetail;
    private String ward;
    private String subRegion;
    private String region;
    private String typeAddress;
    private String isDefault;
}
