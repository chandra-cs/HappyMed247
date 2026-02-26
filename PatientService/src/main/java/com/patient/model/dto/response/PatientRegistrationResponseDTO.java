package com.patient.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientRegistrationResponseDTO {

    private String username;
    private String message;

}