package com.example.motorbike_be.services.impl;


import com.example.motorbike_be.dto.product.request.ProductRequest;
import com.example.motorbike_be.dto.product.request.ProductUpdateRequest;
import com.example.motorbike_be.dto.product.response.ProductResponse;
import com.example.motorbike_be.enums.ProductStatus;
import com.example.motorbike_be.models.CategoryProduct;
import com.example.motorbike_be.models.Pagination;
import com.example.motorbike_be.models.Product;
import com.example.motorbike_be.repositories.CategoryProductRepository;
import com.example.motorbike_be.repositories.ProductRepository;
import com.example.motorbike_be.services.CloudinaryService;
import com.example.motorbike_be.services.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.UUID;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryProductRepository categoryProductRepository;
    private final CloudinaryService cloudinaryService;

    @Override
    public Pagination<ProductResponse> getAllProduct(int page,int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPagination = productRepository.findAllProduct(pageable);
        List<ProductResponse> responses= productPagination
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .getContent();
        return Pagination.of(productPagination, responses);
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
    public ProductResponse updateProduct(String id, ProductUpdateRequest updateRequest, MultipartFile image) throws IOException{
        UUID productId = UUID.fromString(id);
        String imageUrl = cloudinaryService.uploadImage(image);
        UUID categoryId = UUID.fromString(updateRequest.getCategoryId());
        Instant now = Instant.now();
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        CategoryProduct categoryProduct = categoryProductRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category product not found"));
        modelMapper.map(updateRequest, product);
        product.setCategoryProduct(categoryProduct);
        product.setImage(imageUrl);
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

    @Override
    public Pagination<ProductResponse> searchProduct(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPagination = productRepository.searchProductByName(name, pageable)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        List<ProductResponse> responses = productPagination
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .getContent();
        return Pagination.of(productPagination, responses);
    }

    @Override
    public Pagination<ProductResponse> getProductByCategory(String categoryId, int page, int size) {
        UUID uuid = UUID.fromString(categoryId);
        if (!categoryProductRepository.existsById(uuid)) {
            throw new RuntimeException("Category not found");
        }
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage = productRepository.findByCategoryProductId(uuid, pageable);
        List<ProductResponse> responses = productPage
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .getContent();
        return Pagination.of(productPage, responses);
    }
}