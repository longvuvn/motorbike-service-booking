package com.example.motorbike_be.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "\"refresh_token\"")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken extends Auditing{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 1024)
    private String refreshToken;

    private Instant issued_at;
    private Instant expiryDate;

    @Column(nullable = false)
    private boolean revoked;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
