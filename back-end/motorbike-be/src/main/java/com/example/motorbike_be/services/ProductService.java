package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.product.request.ProductRequest;
import com.example.motorbike_be.dto.product.request.ProductUpdateRequest;
import com.example.motorbike_be.dto.product.response.ProductResponse;
import com.example.motorbike_be.models.Pagination;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface ProductService {
    Pagination<ProductResponse> getAllProduct(int page, int size);
    ProductResponse getProductById(String id);
    ProductResponse createProduct(ProductRequest productRequest, MultipartFile image) throws IOException;
    ProductResponse updateProduct(String id, ProductUpdateRequest updateRequest, MultipartFile image)throws IOException;
    void deleteProduct(String id);
    Pagination<ProductResponse> searchProduct(String name, int page, int size);
    Pagination<ProductResponse> getProductByCategory(String categoryId, int page, int size);
}
