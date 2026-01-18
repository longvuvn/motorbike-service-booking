package com.example.motorbike_be.controllers;


import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.dto.service.request.ServiceRequest;
import com.example.motorbike_be.dto.service.request.ServiceUpdateRequest;
import com.example.motorbike_be.dto.service.response.ServiceResponse;
import com.example.motorbike_be.models.Pagination;
import com.example.motorbike_be.services.ServiceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/v1/services")
@RequiredArgsConstructor
@Tag(name = "Service API", description = "Service API")
public class ServiceController {

    private final ServiceService serviceService;

    @GetMapping
    public ResponseEntity<ApiResponse<Pagination<ServiceResponse>>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Pagination<ServiceResponse> services = serviceService.getAllServices(page, size);
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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ServiceResponse>> create(
            @Valid
            @RequestPart("service") ServiceRequest request,
            @RequestPart("image") MultipartFile image) throws Exception{
        ServiceResponse service = serviceService.createService(request, image);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "Create Service Successful",
                        service,
                        ""
                )
        );
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ServiceResponse>> update(
            @Valid @PathVariable String id,
            @RequestPart("service") ServiceUpdateRequest updateRequest,
            @RequestPart("image") MultipartFile image) throws Exception{
        ServiceResponse service = serviceService.updateService(id, updateRequest, image);
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

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Pagination<ServiceResponse>>> search(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        Pagination<ServiceResponse> response = serviceService.searchService(name, page, size);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Search Service Successful",
                        response,
                        ""
                )
        );
    }

    @GetMapping("/category")
    public ResponseEntity<ApiResponse<Pagination<ServiceResponse>>> getByCategory(
            @RequestParam String categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Pagination<ServiceResponse> response = serviceService.getServiceByCategory(categoryId, page, size);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get Service By Category Successful",
                        response,
                        ""
                )
        );
    }
}
