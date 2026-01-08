package com.example.motorbike_be.dto.address.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnDefaultAddressRequest {
    private String id;
    private String isDefault;
}
