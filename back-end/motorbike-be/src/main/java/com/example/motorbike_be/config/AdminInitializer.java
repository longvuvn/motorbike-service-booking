package com.example.motorbike_be.config;



import com.example.motorbike_be.enums.UserStatus;
import com.example.motorbike_be.models.Admin;
import com.example.motorbike_be.models.Role;
import com.example.motorbike_be.repositories.AdminRepository;
import com.example.motorbike_be.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminInitializer implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if(adminRepository.count() == 0 ){
            Role role = roleRepository.findByName("ADMIN");
            Admin admin = new Admin();
            admin.setUsername("admin");
            admin.setFullName("ADMIN");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setDepartment("Manager");
            admin.setStatus(UserStatus.ACTIVE);
            admin.setAvatar("/image/c21f969b5f03d33d43e04f8f136e7682.png");
            admin.setRole(role);
            adminRepository.save(admin);
        }
        System.out.println(">>> Saved admin");
    }
}