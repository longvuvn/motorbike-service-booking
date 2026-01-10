package com.example.motorbike_be.dto.booking.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingServiceResponse {
    private String id;
    private String finalPrice;
    private String bookingId;
    private String serviceId;
    private String serviceName;
}
