package com.patient.exception.feign;

import lombok.NoArgsConstructor;

public class ResourceNotFoundException extends DownstreamServiceException {
    public ResourceNotFoundException(String message) {
        super(404,message);
    }
}
