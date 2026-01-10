package com.example.motorbike_be.dto.booking.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingServiceRequest {
    @NotBlank(message = "Mời bạn chọn dịch vụ")
    private String serviceId;

    @NotBlank(message = "FinalPrice không được để trống")
    private String finalPrice;
}
