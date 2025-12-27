package com.example.motorbike_be.models;


import com.example.motorbike_be.enums.ServiceStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "\"services\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Service extends Auditing {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Tên dịch vụ không được để trống")
    @Column(nullable = false, length = 255)
    private String serviceName;

    @NotBlank(message = "Mô tả không được để trống")
    @Column(nullable = false, length = 1000)
    private String description;

    @NotBlank(message = "Ảnh không được để trống")
    @Column(nullable = false)
    private String image;

    @NotNull(message = "Giá thấp nhất không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá thấp nhất phải lớn hơn 0")
    @Column(nullable = false)
    private BigDecimal estimatedMinPrice;

    @NotNull(message = "Giá cao nhất không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá cao nhất phải lớn hơn 0")
    @Column(nullable = false)
    private BigDecimal estimatedMaxPrice;

    @NotNull(message = "Thời gian thực hiện không được để trống")
    @Min(value = 1, message = "Thời gian phải lớn hơn 0 phút")
    @Column(nullable = false)
    private Integer estimatedDurationMinutes;

    @NotNull(message = "Trạng thái dịch vụ không được để trống")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceStatus status;

    @NotNull(message = "Danh mục dịch vụ không được để trống")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryService categoryService;

    @OneToMany(mappedBy = "service", fetch = FetchType.LAZY)
    private List<BookingService> bookingServices;
}

