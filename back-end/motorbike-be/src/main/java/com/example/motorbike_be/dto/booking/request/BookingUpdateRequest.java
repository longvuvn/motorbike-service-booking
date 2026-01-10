package com.example.motorbike_be.dto.booking.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingUpdateRequest {
    @NotBlank
    private String totalPrice;
    @NotBlank
    private String status;
    @Valid
    private List<BookingServiceRequest> bookingServiceRequests;
    private String note;
}
