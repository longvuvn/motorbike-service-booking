package com.example.motorbike_be.models;


import com.example.motorbike_be.enums.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "\"bookings\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends Auditing{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Size(max = 255)
    private String note;
    private BigDecimal totalPrice;

    private Instant bookingDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingService> bookingServices;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY)
    private List<InvoiceBooking> invoiceBookings;
}
