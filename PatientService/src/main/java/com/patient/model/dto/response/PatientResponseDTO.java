package com.patient.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class PatientResponseDTO {
    private Long patientId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String insuranceProvider;
    private String insuranceNumber;
    private String insuranceType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
