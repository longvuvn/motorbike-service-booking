package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.address.request.AddressRequest;
import com.example.motorbike_be.dto.address.request.AddressUpdateRequest;
import com.example.motorbike_be.dto.address.request.UnDefaultAddressRequest;
import com.example.motorbike_be.dto.address.response.AddressResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAddressByCustomerId(String customerId);
    AddressResponse createAddress(String customerId, AddressRequest request);
    AddressResponse updateAddress(String addressId, AddressUpdateRequest request);
    AddressResponse unDefaultAddress(String customerId, UnDefaultAddressRequest request);
    void deleteAddress(String addressId);
}
