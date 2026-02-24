package com.patient.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String msg) {
        super(msg);
    }
}
