package com.example.motorbike_be.dto.booking.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private String id;
    private String customerId;
    private String customerName;
    private String bookingDate;
    private String totalPrice;
    private String status;
    private List<BookingServiceResponse> bookingServiceResponses;
    private String note;
    private String createdAt;
    private String updatedAt;
}
