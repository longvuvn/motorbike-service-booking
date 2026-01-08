package com.example.motorbike_be.dto.address.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private String id;
    private String fullName;
    private String phoneNumber;
    private String addressDetail;
    private String ward;
    private String subRegion;
    private String region;
    private String typeAddress;
    private String isDefault;
    private String customerId;
    private String createdAt;
    private String updatedAt;
}
