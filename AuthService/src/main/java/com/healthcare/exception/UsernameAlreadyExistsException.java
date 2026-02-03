package com.healthcare.exception;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class UsernameAlreadyExistsException extends Exception {
    private String message;

}
