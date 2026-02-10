package com.healthcare.exception.role;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SameRoleUpdationException extends RuntimeException {
    public SameRoleUpdationException(String msg) {
    }
}
