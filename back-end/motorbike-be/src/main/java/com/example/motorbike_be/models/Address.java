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
    private String fullName;
    private String phoneNumber;
    @Column(nullable = false)
    private String addressDetail;

    private String ward;
    private String subRegion;
    private String region;

    @Enumerated(EnumType.STRING)
    private AddressStatus typeAddress;

    @Column(nullable = false)
    private boolean isDefault;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private List<Order> orders;
}
