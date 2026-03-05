package com.patient.model.dto.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorResponseDto {
    private Integer errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;
    private String apiPath;

    public ErrorResponseDto(Integer errorCode, String errorMessage, LocalDateTime timestamp, String apiPath) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
        this.apiPath = apiPath;
    }

}
