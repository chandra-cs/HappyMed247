package com.patient.exception.handler;

import com.patient.exception.feign.ResourceConflictException;
import com.patient.model.dto.client.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class PatientServiceGlobalExcetionHandler {

    @ExceptionHandler(ResourceConflictException.class)
    public ResponseEntity<ErrorResponseDto> handleConflict(
            ResourceConflictException ex, HttpServletRequest request) {

        ErrorResponseDto error = ErrorResponseDto.builder()
                .errorCode(HttpStatus.CONFLICT.value())
                .errorMessage(ex.getUserFriendlyMessage())
                .timestamp(LocalDateTime.now())
                .apiPath(request.getRequestURI())
                .build();

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception e, HttpServletRequest request) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .apiPath(request.getRequestURI())
                .errorCode(404)
                .errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }//handleException()

}
