package com.healthcare.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponseDTO {

    private Integer statusCode;
    private String message;

}
