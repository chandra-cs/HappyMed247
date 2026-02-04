package com.healthcare.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RoleNameNotFoundException extends RuntimeException {
    public RoleNameNotFoundException(String msg) {
        super(msg);
    }
}
