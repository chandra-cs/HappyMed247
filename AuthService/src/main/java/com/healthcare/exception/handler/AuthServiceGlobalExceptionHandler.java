package com.healthcare.exception.handler;

import com.healthcare.exception.EmailNotFoundException;
import com.healthcare.exception.PasswordMismatchException;
import com.healthcare.exception.UsernameAlreadyExistsException;
import com.healthcare.exception.UsernameNotFoundException;
import com.healthcare.model.dto.response.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.healthcare.exception.handler.ErrorResponseDTOBuilder.buildErrorResponse;

import java.time.Instant;


@RestControllerAdvice
public class AuthServiceGlobalExceptionHandler {



    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleUsernameAlreadyExists(UsernameAlreadyExistsException ex, HttpServletRequest request) {

        return buildErrorResponse(ex, request, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleUsernameNotFound(UsernameNotFoundException ex, HttpServletRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleEmailNotFound(
            EmailNotFoundException ex,
            HttpServletRequest request) {

        return buildErrorResponse(ex, request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<ErrorResponseDTO> handlePasswordMismatch(PasswordMismatchException ex, HttpServletRequest request) {
        return buildErrorResponse(ex, request, HttpStatus.UNAUTHORIZED);
    }



}//class
