package com.healthcare.exception.handler;

import com.healthcare.exception.RoleAlreadyExistsException;
import com.healthcare.model.dto.response.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.healthcare.exception.handler.ErrorResponseDTOBuilder.buildErrorResponse;

@RestControllerAdvice
public class RoleExcetionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDTO> handleRoleAlreadyExistsException(RoleAlreadyExistsException ex, HttpServletRequest request) {
        return buildErrorResponse(ex,request, HttpStatus.CONFLICT);
    }

}//class
