package com.example.motorbike_be.dto.booking.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingServiceRequest {
    private String serviceId;
    private String bookingId;
    private String finalPrice;
}
