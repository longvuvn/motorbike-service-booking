package com.example.motorbike_be.models;


import com.example.motorbike_be.enums.CategoryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "\"category_products\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryProduct extends Auditing{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String categoryName;

    @Enumerated(EnumType.STRING)
    private CategoryStatus status;

    @OneToMany(mappedBy = "categoryProduct", fetch = FetchType.LAZY)
    private List<Product> products;
}
