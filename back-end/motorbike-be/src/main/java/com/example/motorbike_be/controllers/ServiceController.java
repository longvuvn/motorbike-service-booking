package com.example.motorbike_be.controllers;


import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.dto.service.request.ServiceRequest;
import com.example.motorbike_be.dto.service.request.ServiceUpdateRequest;
import com.example.motorbike_be.dto.service.response.ServiceResponse;
import com.example.motorbike_be.services.ServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ServiceResponse>>> getAll(){
        List<ServiceResponse> services = serviceService.getAllServices();
        return ResponseEntity.ok(
            new ApiResponse<>(
                    HttpStatus.OK.value(),
                    "Get All Service Successful",
                    services,
                    ""
            )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ServiceResponse>> getById(@PathVariable String id){
        ServiceResponse service = serviceService.getServiceById(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get Service By Id Successful",
                        service,
                        ""
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ServiceResponse>> create(@Valid @RequestBody ServiceRequest request){
        ServiceResponse service = serviceService.createService(request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "Create Service Successful",
                        service,
                        ""
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ServiceResponse>> update(@Valid @PathVariable String id, @RequestBody ServiceUpdateRequest updateRequest){
        ServiceResponse service = serviceService.updateService(id, updateRequest);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Update Service Successful",
                        service,
                        ""
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id){
        serviceService.deleteService(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Delete Service Successful"
                )
        );
    }
}
