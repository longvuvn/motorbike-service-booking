package com.example.motorbike_be.dto.gemini.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsightResponse {
    private String analysis;
    private List<String> bestTimeSlots;
    private String trafficStatus;
}
