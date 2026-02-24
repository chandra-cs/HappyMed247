package com.patient.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ConsentResponseDTO {
    private Long consentId;
    private String consentType;
    private boolean isGiven;
    private LocalDate consentDate;

}
