package com.example.motorbike_be.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "\"customers\"")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> orders;
}

