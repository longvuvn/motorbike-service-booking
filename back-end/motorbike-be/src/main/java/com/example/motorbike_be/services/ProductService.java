package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.product.request.ProductRequest;
import com.example.motorbike_be.dto.product.request.ProductUpdateRequest;
import com.example.motorbike_be.dto.product.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(String id);
    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse updateProduct(String id, ProductUpdateRequest updateRequest);
    void deleteProduct(String id);
}
