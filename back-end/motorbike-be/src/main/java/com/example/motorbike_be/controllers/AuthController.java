package com.example.motorbike_be.controllers;

import com.example.motorbike_be.dto.auth.request.AuthRequest;
import com.example.motorbike_be.dto.auth.request.RefreshTokenRequest;
import com.example.motorbike_be.dto.auth.response.AuthResponse;
import com.example.motorbike_be.dto.customer.request.CustomerRequest;
import com.example.motorbike_be.dto.customer.response.CustomerResponse;
import com.example.motorbike_be.dto.response.ApiResponse;
import com.example.motorbike_be.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Auth Controller", description = "API for Auth")
public class AuthController {

    private final AuthService authService;

    @Operation(summary = "Register", description = "Register Account")
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<CustomerResponse>> register(@Valid @RequestBody CustomerRequest customerRequest){
        CustomerResponse response = authService.register(customerRequest);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "Register Successful",
                        response,
                        ""
                )
        );
    }

    @Operation(summary = "Login", description = "Authenticate user and return access token + refresh token")
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(@Valid @RequestBody AuthRequest authRequest){
        AuthResponse response = authService.login(authRequest);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Login Successful",
                        response,
                        null
                )
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<ApiResponse<AuthResponse>> refresh(@CookieValue(name = "refresh_token", required = false) String request){
        AuthResponse response = authService.refreshToken(request);
        return ResponseEntity.ok(
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Refresh Token Successful",
                        response,
                        null
                )
        );
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout(@RequestBody RefreshTokenRequest refreshTokenRequest){
        authService.logout(refreshTokenRequest);
        return new ApiResponse<>(HttpStatus.OK.value(), "Logout Successful", null, null);
    }
}
