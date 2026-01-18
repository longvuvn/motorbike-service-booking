package com.example.motorbike_be.controllers;


import com.example.motorbike_be.dto.product.request.ProductRequest;
import com.example.motorbike_be.dto.product.request.ProductUpdateRequest;
import com.example.motorbike_be.dto.product.response.ProductResponse;
import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.models.Pagination;
import com.example.motorbike_be.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;




@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Product API", description = "Product API")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<Pagination<ProductResponse>>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Pagination<ProductResponse> getAll = productService.getAllProduct(page, size);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get All Products By Category Successful",
                        getAll,
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
    public ResponseEntity<ApiResponse<ProductResponse>> create(
            @Valid @RequestPart("product") ProductRequest request,
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


    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ProductResponse>> update(
            @PathVariable String id,
            @Valid @RequestPart("product") ProductUpdateRequest updateRequest,
            @RequestPart("image") MultipartFile image) throws IOException{
        ProductResponse product = productService.updateProduct(id, updateRequest,image);
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

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<Pagination<ProductResponse>>> search(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Pagination<ProductResponse> response = productService.searchProduct(name, page, size);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Search Products Successful",
                        response,
                        ""
                )
        );
    }


    @GetMapping("/category")
    public ResponseEntity<ApiResponse<Pagination<ProductResponse>>> getByCategory(
            @RequestParam String categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        Pagination<ProductResponse> response = productService.getProductByCategory(categoryId, page, size);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Get Product By Category Successful",
                        response,
                        ""
                )
        );
    }
}