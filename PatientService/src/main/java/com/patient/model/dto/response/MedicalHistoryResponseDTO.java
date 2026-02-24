package com.patient.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MedicalHistoryResponseDTO {
    private Long medicalHistoryId;
    private String condition;
    private String notes;
    private LocalDate startDate;
    private LocalDate endDate;
}


