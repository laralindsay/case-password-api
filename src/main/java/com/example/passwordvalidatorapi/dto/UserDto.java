package com.example.passwordvalidatorapi.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid", regexp = "^[A-Za-z0-9+_.-]+@outlook.com")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Min(value = 1, message = "Password should be greater than 1")
    @Max(value = 20, message = "Password should be less than 20")
    @Pattern(message = "Password should be valid", regexp = "^[(?=.*\\d)(?=.*[!@#$%^&*()\\-+])[0-9!@#$%^&*()\\-+]{4,8}$]")
    private String password;
}
