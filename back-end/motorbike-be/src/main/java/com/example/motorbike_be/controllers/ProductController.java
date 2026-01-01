package com.example.motorbike_be.controllers;


import com.example.motorbike_be.dto.product.request.ProductRequest;
import com.example.motorbike_be.dto.product.request.ProductUpdateRequest;
import com.example.motorbike_be.dto.product.response.ProductResponse;
import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAll(){
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get All Products successful",
                        products,
                        ""
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> getById(@PathVariable String id){
        ProductResponse product = productService.getProductById(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get Product By Id successful",
                        product,
                        ""
                )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> create(@Valid @RequestBody ProductRequest request){
        ProductResponse product = productService.createProduct(request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Create Product successful",
                        product,
                        ""
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductResponse>> update(@PathVariable String id, @Valid @RequestBody ProductUpdateRequest updateRequest){
        ProductResponse product = productService.updateProduct(id, updateRequest);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Update Product successful",
                        product,
                        ""
                )
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id){
        productService.deleteProduct(id);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Delete Product successful"
                )
        );
    }
}
