package com.patient.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AllergyRequestDTO {
    @NotBlank(message = "Allergy name is required")
    private String allergyName;

    @NotBlank(message = "Reaction is required")
    private String reaction;

    @NotBlank(message = "Severity is required")
    private String severity;
}
