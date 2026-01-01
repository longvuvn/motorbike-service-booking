package com.example.motorbike_be.services;


import com.example.motorbike_be.models.User;

public interface RefreshTokenService {
    void createRefreshToken(User user, String refreshTokenRequest);
    void revokeToken (String refreshToken);
    void validateToken(String refreshToken);
}
