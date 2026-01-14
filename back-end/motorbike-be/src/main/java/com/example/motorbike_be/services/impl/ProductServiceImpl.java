package com.example.motorbike_be.services.impl;


import com.example.motorbike_be.dto.product.request.ProductRequest;
import com.example.motorbike_be.dto.product.request.ProductUpdateRequest;
import com.example.motorbike_be.dto.product.response.ProductResponse;
import com.example.motorbike_be.enums.ProductStatus;
import com.example.motorbike_be.models.CategoryProduct;
import com.example.motorbike_be.models.Product;
import com.example.motorbike_be.repositories.CategoryProductRepository;
import com.example.motorbike_be.repositories.ProductRepository;
import com.example.motorbike_be.services.CloudinaryService;
import com.example.motorbike_be.services.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryProductRepository categoryProductRepository;
    private final CloudinaryService cloudinaryService;

    @Override
    public List<ProductResponse>  getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(String id) {
        UUID uuid = UUID.fromString(id);
        Product product = productRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    @Transactional
    public ProductResponse createProduct(ProductRequest productRequest, MultipartFile image) throws IOException {
        UUID uuid = UUID.fromString(productRequest.getCategoryId());
        String imageUrl = cloudinaryService.uploadImage(image);
        CategoryProduct categoryProduct = categoryProductRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        if(productRepository.existsByProductName(productRequest.getProductName())){
            throw new DataIntegrityViolationException("Product already exists");
        }
        Product product = modelMapper.map(productRequest, Product.class);
        product.setCategoryProduct(categoryProduct);
        product.setImage(imageUrl);
        product.setStatus(ProductStatus.IN_STOCK);
        return modelMapper.map(productRepository.save(product), ProductResponse.class);
    }

    @Override
    public ProductResponse updateProduct(String id, ProductUpdateRequest updateRequest) {
        UUID productId = UUID.fromString(id);
        UUID categoryId = UUID.fromString(updateRequest.getCategoryId());
        Instant now = Instant.now();
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        CategoryProduct categoryProduct = categoryProductRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category product not found"));
        modelMapper.map(updateRequest, product);
        product.setCategoryProduct(categoryProduct);
        product.setUpdatedAt(now);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductResponse.class);
    }

    @Override
    public void deleteProduct(String id) {
        UUID uuid = UUID.fromString(id);
        Product product = productRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }
}
