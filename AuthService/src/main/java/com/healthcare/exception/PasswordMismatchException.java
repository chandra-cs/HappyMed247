package com.healthcare.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PasswordMismatchException extends RuntimeException {

    private String message;


}
