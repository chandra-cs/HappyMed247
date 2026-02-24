package com.patient.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AllergyNotFoundException extends RuntimeException {
    public AllergyNotFoundException(String s) {
        super(s);
    }
}
