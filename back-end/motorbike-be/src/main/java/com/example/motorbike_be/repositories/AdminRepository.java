package com.example.motorbike_be.repositories;

import com.example.motorbike_be.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository <Admin, UUID>{
}
