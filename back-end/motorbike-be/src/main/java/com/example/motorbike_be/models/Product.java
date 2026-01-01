package com.example.motorbike_be.models;


import com.example.motorbike_be.enums.ProductStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "\"products\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends Auditing{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String productName;

    @NotNull(message = "Giá không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá thấp nhất phải lớn hơn 0")
    @Column(nullable = false)
    private BigDecimal price;

    private BigDecimal finalPrice;
    @Column(nullable = false)
    private String image;

    @NotBlank(message = "Mô tả không được để trống")
    @Column(nullable = false, length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @NotNull(message = "Danh mục sản phẩm không được để trống")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryProduct categoryProduct;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;
}
