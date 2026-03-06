package com.patient.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EmergencyContactNotFoundException extends  RuntimeException {
    public EmergencyContactNotFoundException(String msg) {
        super(msg);
    }
}
