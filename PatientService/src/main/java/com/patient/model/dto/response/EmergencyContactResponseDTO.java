package com.patient.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmergencyContactResponseDTO {
    private Long emergencyContactId;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String emergencyContactEmail;
}
