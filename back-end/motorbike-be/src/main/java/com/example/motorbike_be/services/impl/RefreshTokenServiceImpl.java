package com.example.motorbike_be.services.impl;


import com.example.motorbike_be.models.RefreshToken;
import com.example.motorbike_be.models.User;
import com.example.motorbike_be.repositories.RefreshTokenRepository;
import com.example.motorbike_be.services.RefreshTokenService;
import com.example.motorbike_be.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;



@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    @Value("${jwt.expiration.refresh-token}")
    private long jwtRefreshToken;
    private final RefreshTokenRepository refreshTokenRepository;
    private final ModelMapper modelMapper;
    private final JWTUtil jwtUtil;


    @Override
    public void createRefreshToken(User user, String refreshTokenRequest) {
        Instant now = Instant.now();
        Instant expiry = now.plus(jwtRefreshToken, ChronoUnit.MILLIS);
        String token = jwtUtil.generateRefreshToken(user);
        RefreshToken refreshToken = modelMapper.map(refreshTokenRequest, RefreshToken.class);
        refreshToken.setIssued_at(now);
        refreshToken.setExpiryDate(expiry);
        refreshToken.setUser(user);
        refreshToken.setRefreshToken(token);
        refreshToken.setRevoked(false);
        refreshTokenRepository.save(refreshToken);
    }

    @Override
    public void revokeToken(String refreshToken) {
        Instant now = Instant.now();
        RefreshToken token = refreshTokenRepository.findByRefreshToken(refreshToken);

        token.setRevoked(true);
        token.setDeletedAt(now);
        refreshTokenRepository.save(token);
    }

    @Override
    public void validateToken(String refreshToken) {
        RefreshToken token = refreshTokenRepository.findByRefreshToken(refreshToken);
        if(token.isRevoked()){
            throw new RuntimeException("Token is revoked");
        }
        Instant now = Instant.now();
        if(now.isAfter(token.getExpiryDate())){
            throw new RuntimeException("Token is expired");
        }
    }
}
