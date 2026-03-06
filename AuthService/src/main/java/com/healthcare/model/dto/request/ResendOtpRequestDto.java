package com.healthcare.model.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResendOtpRequestDto {
    private String email;
    private String password;
}
