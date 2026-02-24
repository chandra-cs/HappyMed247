package com.patient.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class VisitNotFoundException extends  RuntimeException {
    public VisitNotFoundException(String msg) {
        super(msg);
    }
}
