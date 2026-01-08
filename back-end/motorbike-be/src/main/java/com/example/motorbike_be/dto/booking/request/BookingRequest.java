package com.example.motorbike_be.dto.booking.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private String customerId;
    private String bookingDate;
    private List<BookingServiceRequest> bookingServiceRequests;
    private String note;
}
