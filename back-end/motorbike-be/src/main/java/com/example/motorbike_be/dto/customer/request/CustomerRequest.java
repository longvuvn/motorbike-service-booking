package com.example.motorbike_be.dto.customer.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String fullName;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
}
