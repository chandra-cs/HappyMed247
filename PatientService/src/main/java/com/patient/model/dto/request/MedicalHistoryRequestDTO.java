package com.patient.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicalHistoryRequestDTO {

    @NotBlank(message = "Condition is required")
    private String condition;
    private String notes;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    private LocalDate endDate;

}
