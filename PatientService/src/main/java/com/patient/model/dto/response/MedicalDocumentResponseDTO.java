package com.patient.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicalDocumentResponseDTO {
    private Long id;
    private String fileName;
    private String filePath;

}
