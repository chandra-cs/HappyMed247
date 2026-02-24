package com.patient.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VisitRequestDTO {

    @NotNull(message = "Visit date is required")
    private LocalDate visitDate;

    @NotBlank(message = "Reason is required")
    private String reason;

    private String diagnosis;
    //private String treatment;
    //private String doctorName;
    private String notes;
}
