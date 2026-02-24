package com.healthcare.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequestDTO {

    @NotBlank(message = "Username can not be empty")
    @Size(min = 5, max = 20, message = "username must be between 5 & 20 characters")
    private String username;

    @NotBlank(message = "Email address can not be empty")
    @Email(message = "Invalid Email address")
    private String email;

    @NotBlank(message = "Password can not be empty")
    private String password;

    @NotBlank(message = "Confirm password can not be empty")
    private String confirmPassword;

    @NotBlank(message = "Role can not be empty")
    @Pattern(regexp = "ADMIN | SUPER_ADMIN | DOCTOR | PATIENT |NURSE | OTHER"
    ,message = "Role must be one of ADMIN, SUPER_ADMIN, DOCTOR, PATIENT, OTHER")
    private String role;
}
