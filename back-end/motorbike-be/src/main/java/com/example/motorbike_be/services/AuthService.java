package com.example.motorbike_be.services;

import com.example.motorbike_be.dto.auth.request.AuthRequest;
import com.example.motorbike_be.dto.auth.request.RefreshTokenRequest;
import com.example.motorbike_be.dto.auth.response.AuthResponse;
import com.example.motorbike_be.dto.customer.request.CustomerRequest;
import com.example.motorbike_be.dto.customer.response.CustomerResponse;

public interface AuthService {
    AuthResponse login(AuthRequest authRequest);
    AuthResponse refreshToken(String refreshTokenRequest);
    CustomerResponse register(CustomerRequest customerRequest);
    void logout(RefreshTokenRequest refreshToken);
}
