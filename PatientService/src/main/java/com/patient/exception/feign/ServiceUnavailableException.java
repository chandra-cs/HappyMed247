package com.patient.exception.feign;

import lombok.NoArgsConstructor;

public class ServiceUnavailableException extends DownstreamServiceException{
    public ServiceUnavailableException(String message) {
        super(404,message);
    }
}
