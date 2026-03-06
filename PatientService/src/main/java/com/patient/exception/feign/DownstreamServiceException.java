package com.patient.exception.feign;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter

public class DownstreamServiceException extends RuntimeException {

    private final Integer statusCode;
    private final String userFriendlyMessage;

    public DownstreamServiceException(Integer statusCode, String userFriendlyMessage) {
        super(userFriendlyMessage);
        this.statusCode = statusCode;
        this.userFriendlyMessage = userFriendlyMessage;
    }

}
