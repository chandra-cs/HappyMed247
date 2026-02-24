package com.patient.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AllergyResponseDTO {
    private Long allergyId;
    private String allergyName;
    private String reaction;
    private String severity;
}
