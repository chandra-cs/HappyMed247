package com.patient.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ConsentRequestDTO {

    @NotBlank(message = "Consent type is required")
    private String consentType;

    private boolean isGiven;

    @NotNull(message = "Consent date is required")
    private LocalDate consentDate;

}
