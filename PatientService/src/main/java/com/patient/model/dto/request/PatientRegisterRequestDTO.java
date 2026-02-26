package com.patient.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRegisterRequestDTO {

    @NotBlank(message = "username must not be empty")
    @Size(min = 5,max = 20,message = "username length must be between 5-20 characters")
    private String username;

    @NotBlank(message = "password must not be empty")
    private String password;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;


    @NotBlank(message = "gender must be required")
    @Pattern(regexp = "(?i)male|female|other",message = "Gender must be Male,Female or Others only")
    private String gender;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    private LocalDate birthDate;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

    private String address;
    private String city;
    private String state;
    private String insuranceProvider;
    private String insuranceNumber;
    private String insuranceType;
}
