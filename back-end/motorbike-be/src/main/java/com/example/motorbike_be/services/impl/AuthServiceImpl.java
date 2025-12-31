package com.example.motorbike_be.services.impl;


import com.example.motorbike_be.dto.auth.request.AuthRequest;
import com.example.motorbike_be.dto.auth.request.RefreshTokenRequest;
import com.example.motorbike_be.dto.auth.response.AuthResponse;
import com.example.motorbike_be.dto.customer.request.CustomerRequest;
import com.example.motorbike_be.dto.customer.response.CustomerResponse;
import com.example.motorbike_be.models.Customer;
import com.example.motorbike_be.models.User;
import com.example.motorbike_be.repositories.UserRepository;
import com.example.motorbike_be.services.AuthService;
import com.example.motorbike_be.services.CustomerService;
import com.example.motorbike_be.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final CustomerService customerService;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JWTUtil jwtUtil;

    @Override
    public AuthResponse login(AuthRequest authRequest) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Username or Password is incorrect");
        }
        User user = userRepository.findByEmailOrUsername(authRequest.getUsername(), authRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found with username: " + authRequest.getUsername()));
        String accessToken = jwtUtil.generateAccessToken(user);
        String refreshToken = jwtUtil.generateRefreshToken(user);
        return new AuthResponse(accessToken, refreshToken);

    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        String refreshToken = refreshTokenRequest.getRefreshToken();
        if(!jwtUtil.validateToken(refreshToken)){
            return new AuthResponse("Invalid accessToken", "invalid refreshToken");
        }
        String username = jwtUtil.extractUsername(refreshToken);
        User user = userRepository.findByEmailOrUsername(username, username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
        String newAccessToken = jwtUtil.generateAccessToken(user);
        return new AuthResponse(newAccessToken, refreshToken);
    }

    @Override
    public AuthResponse register(CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.createCustomer(customerRequest);
        Customer customer = modelMapper.map(customerResponse, Customer.class);
        return modelMapper.map(customer, AuthResponse.class);
    }
}