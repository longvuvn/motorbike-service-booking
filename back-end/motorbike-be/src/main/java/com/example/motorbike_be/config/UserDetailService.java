package com.example.motorbike_be.config;

import com.example.motorbike_be.models.Role;
import com.example.motorbike_be.models.User;
import com.example.motorbike_be.repositories.RoleRepository;
import com.example.motorbike_be.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Configuration
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailOrUsername(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        Role role = roleRepository.findById(user.getRole().getId())
                .orElseThrow(() -> new RuntimeException("Role not found. ID: " + user.getRole().getId()));
        return org.springframework.security.core.userdetails.User.builder()
                .username(getUserByEmailOrUsername(user.getEmail(), user.getUsername()).getUsername())
                .password(user.getPassword())
                .roles(role.getName())
                .build();
    }


    private User getUserByEmailOrUsername(String email, String username){
        return userRepository.findByEmailOrUsername(email, username)
                .orElseThrow(() -> new RuntimeException("User not found with username or email : " + username));
    }
}
