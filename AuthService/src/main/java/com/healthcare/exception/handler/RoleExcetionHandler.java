package com.healthcare.exception.handler;

import com.healthcare.exception.role.RoleAlreadyExistsException;
import com.healthcare.exception.role.RoleNameMismatchException;
import com.healthcare.exception.role.RoleNameNotFoundException;
import com.healthcare.exception.role.SameRoleUpdationException;
import com.healthcare.model.dto.response.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.healthcare.exception.handler.ErrorResponseDTOBuilder.buildErrorResponse;

@RestControllerAdvice
public class RoleExcetionHandler {

    @ExceptionHandler(RoleAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleRoleAlreadyExistsException(RoleAlreadyExistsException ex, HttpServletRequest request) {
        return buildErrorResponse(ex,request, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RoleNameNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleRoleNameNotFoundException(RoleNameNotFoundException ex, HttpServletRequest request) {
        return buildErrorResponse(ex,request, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoleNameMismatchException.class)
    public ResponseEntity<ErrorResponseDTO> handleRoleNameMismatchException(RoleNameMismatchException ex, HttpServletRequest request) {
        return buildErrorResponse(ex,request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SameRoleUpdationException.class)
    public ResponseEntity<ErrorResponseDTO> handleSameRoleUpdationException(SameRoleUpdationException ex, HttpServletRequest request) {
        return buildErrorResponse(ex,request,HttpStatus.CONFLICT);
    }


}//class
