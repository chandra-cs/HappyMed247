package com.patient.exception.feign;

import lombok.NoArgsConstructor;

public class ResourceConflictException extends DownstreamServiceException {

    public ResourceConflictException(String message) {
        super(409,message);
    }
}
