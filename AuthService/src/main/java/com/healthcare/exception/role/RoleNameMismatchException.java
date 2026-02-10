package com.healthcare.exception.role;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RoleNameMismatchException extends RuntimeException {

    public RoleNameMismatchException(String msg) {
        super(msg);
    }
}
