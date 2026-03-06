package com.healthcare.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResendOtpResponseDto {
    private String message;
    private Boolean status;
}
