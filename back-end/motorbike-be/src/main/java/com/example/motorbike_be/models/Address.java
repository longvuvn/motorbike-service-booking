package com.example.motorbike_be.models;


import com.example.motorbike_be.enums.AddressStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "\"address\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends Auditing{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Họ và tên không được để trống")
    @NotEmpty(message = "Thiếu Họ Và Tên")
    private String fullName;

    @NotEmpty(message = "Thiếu số điện thoại")
    @NotBlank(message = "Số điện thoại không được để trống")
    private String phoneNumber;

    @NotBlank(message = "Địa chỉ cụ thể không để trống")
    @NotEmpty(message = "Thiếu địa chỉ cụ thể")
    @Column(nullable = false)
    private String addressDetail;

    private String ward;
    private String subRegion;
    private String region;

    @Enumerated(EnumType.STRING)
    private AddressStatus typeAddress;

    @Column(nullable = false)
    private boolean idDefault;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<Order> orders;
}
