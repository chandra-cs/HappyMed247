package com.healthcare.exception.auth;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class EmailNotFoundException extends Exception {

    public EmailNotFoundException(String message) {
        super(message);
    }

}
