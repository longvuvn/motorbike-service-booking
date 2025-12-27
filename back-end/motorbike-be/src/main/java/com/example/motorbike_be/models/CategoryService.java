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
@Table(name = "\"category_services\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryService extends Auditing{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String categoryName;

    @Enumerated(EnumType.STRING)
    private CategoryStatus status;

    @OneToMany(mappedBy = "categoryService", fetch = FetchType.LAZY)
    private List<Service> services;
}
