package com.healthcare.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@NoArgsConstructor
public class EmailNotFoundException extends Exception {

    public EmailNotFoundException(String message) {
        super(message);
    }

}
