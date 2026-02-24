package com.healthcare.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ValidationExcetionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError fieldError : fieldErrors) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(HandlerMethodValidationException ex) {
        Map<String, String> errors = new HashMap<>();
        List<ParameterValidationResult> results = ex.getParameterValidationResults();
        for (ParameterValidationResult result : results) {
            String paramName = result.getMethodParameter().getParameterName();
            String combinedMessage = result.getMethodParameter().getParameterType().getSimpleName() + " " + result.getMethodParameter().getParameterName();
            errors.put(paramName, combinedMessage);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
