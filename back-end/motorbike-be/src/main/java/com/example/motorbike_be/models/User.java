package com.example.motorbike_be.models;
import com.example.motorbike_be.enums.UserStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name = "\"users\"")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Auditing{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Họ Và Tên không được để trống")
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Thiếu Họ Và Tên")
    private String fullName;

    @NotBlank(message = "Username không được để trống")
    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Thiếu username")
    private String username;

    @NotBlank(message = "Mật khẩu không được để trống")
    @NotEmpty(message = "Thiếu mật khẩu")
    @Column(nullable = false, unique = true)
    @Size(min = 8, message = "Mật khẩu có ít nhất 8 kí tự trở lên")
    private String password;
    private String avatar;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.(com|vn)$", message = "Email phải kết thúc bằng .com hoặc .vn")
    private String email;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
}

