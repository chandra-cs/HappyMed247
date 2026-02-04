package com.healthcare.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RoleAlreadyExistsException extends RuntimeException {

    public RoleAlreadyExistsException(String msg) {
        super(msg);
    }
}
