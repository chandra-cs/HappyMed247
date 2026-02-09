package com.healthcare.exception.handler;

import com.healthcare.model.dto.response.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class ErrorResponseDTOBuilder {

    //for not more redundancy of building ErrorResponseDTO class we can have a helper method which can accept the required arguments
    public static ResponseEntity<ErrorResponseDTO> buildErrorResponse(
            Exception ex,
            HttpServletRequest request,
            HttpStatus status) {

        ErrorResponseDTO error = ErrorResponseDTO.builder()
                .errorMessage(ex.getMessage())
                .apiPath(request.getRequestURI())
                .timestamp(Instant.now())
                .errorCode(status.value())
                .build();

        return new ResponseEntity<>(error, status);
    }
}
