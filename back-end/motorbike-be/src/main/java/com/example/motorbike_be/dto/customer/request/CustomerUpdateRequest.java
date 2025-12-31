package com.example.motorbike_be.dto.customer.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    private String fullName;
    private String phoneNumber;
    private String avatar;
}
