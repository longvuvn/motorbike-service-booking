package com.example.motorbike_be.controllers;

import com.example.motorbike_be.dto.address.request.AddressRequest;
import com.example.motorbike_be.dto.address.request.AddressUpdateRequest;
import com.example.motorbike_be.dto.address.request.UnDefaultAddressRequest;
import com.example.motorbike_be.dto.address.response.AddressResponse;
import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.services.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<AddressResponse>>> getAll(@PathVariable String id){
        List<AddressResponse> getAllAddress = addressService.getAddressByCustomerId(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get All Address Successful",
                        getAllAddress,
                        ""
                )
        );
    }

    @PostMapping("/{id}")
    public ResponseEntity<ApiResponse<AddressResponse>> create(@Valid @PathVariable String id, @RequestBody AddressRequest request){
        AddressResponse createAddress = addressService.createAddress(id, request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "Create Address Successful",
                        createAddress,
                        ""
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AddressResponse>> update(@PathVariable String id, @RequestBody AddressUpdateRequest request){
        AddressResponse updateAddress = addressService.updateAddress(id, request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Update Address Successful",
                        updateAddress,
                        ""
                )
        );
    }

    @PutMapping("/customer/{customerId}/default")
    public ResponseEntity<ApiResponse<AddressResponse>> unDefault(@PathVariable String customerId, @RequestBody UnDefaultAddressRequest request){
        AddressResponse response = addressService.unDefaultAddress(customerId, request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Update Successful",
                        response,
                        ""
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id){
        addressService.deleteAddress(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Delete Address Successful"
                )
        );
    }
}
