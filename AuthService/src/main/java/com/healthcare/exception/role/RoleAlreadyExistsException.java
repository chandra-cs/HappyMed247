package com.healthcare.exception.role;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RoleAlreadyExistsException extends RuntimeException {

    public RoleAlreadyExistsException(String msg) {
        super(msg);
    }
}
