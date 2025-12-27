package com.example.motorbike_be.models;


import com.example.motorbike_be.enums.InvoiceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "\"invoices\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends Auditing{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    private String paymentMethod;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY)
    private List<InvoiceBooking> invoiceBookings;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY)
    private List<InvoiceOrder> invoiceOrders;
}
