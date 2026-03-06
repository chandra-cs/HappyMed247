package com.patient.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DocumentNotFoundException extends RuntimeException {
    public DocumentNotFoundException(String msg) {
        super(msg);
    }
}
