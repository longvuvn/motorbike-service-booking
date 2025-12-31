package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookingRepository extends JpaRepository <Booking, UUID>{
}
