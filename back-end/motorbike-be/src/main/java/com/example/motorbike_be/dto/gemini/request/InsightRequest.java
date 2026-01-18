package com.example.motorbike_be.dto.gemini.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsightRequest {
    private String bookingDate;
    private String serviceId;
}
