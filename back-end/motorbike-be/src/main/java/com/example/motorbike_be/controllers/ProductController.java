package com.example.motorbike_be.controllers;


import com.example.motorbike_be.dto.product.request.ProductRequest;
import com.example.motorbike_be.dto.product.request.ProductUpdateRequest;
import com.example.motorbike_be.dto.product.response.ProductResponse;
import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ProductResponse>> create(@Valid @RequestPart("product") ProductRequest request,
                                                               @RequestPart("image") MultipartFile image) throws IOException {
        ProductResponse product = productService.createProduct(request, image);
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
