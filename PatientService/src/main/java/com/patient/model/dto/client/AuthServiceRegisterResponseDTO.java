package com.patient.model.dto.client;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthServiceRegisterResponseDTO {
    private Long userId;
    private String username;
    private String message;
}
