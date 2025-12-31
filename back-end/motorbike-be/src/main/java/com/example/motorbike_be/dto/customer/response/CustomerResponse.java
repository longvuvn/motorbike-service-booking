package com.example.motorbike_be.dto.customer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private String id;
    private String fullName;
    private String userName;
    private String email;
    private String avatar;
    private String phoneNumber;
    private String roleId;
    private String createdAt;
    private String updatedAt;
}
