package com.patient.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class VisitResponseDTO {
    private Long visitId;
    private LocalDate visitDate;
    private String reason;
    private String notes;
}

