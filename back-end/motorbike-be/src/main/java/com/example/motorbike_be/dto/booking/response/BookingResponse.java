package com.example.motorbike_be.dto.booking.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private String id;
    private String serviceId;
    private String bookingId;
    private String finalPrice;
}
