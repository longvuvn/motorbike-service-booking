package com.example.motorbike_be.dto.auth.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    @NotBlank(message = "Nhập username")
    private String username;

    @NotBlank(message = "Nhập mật khẩu")
    private String password;
}
