package com.patient.errordecoder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patient.exception.feign.DownstreamServiceException;
import com.patient.exception.feign.ResourceConflictException;
import com.patient.exception.feign.ResourceNotFoundException;
import com.patient.exception.feign.ServiceUnavailableException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class CustomFeignErrorDecoder implements ErrorDecoder {

    private ObjectMapper objectMapper = new ObjectMapper();
    private ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        int status = response.status();
        String errorMessage = extractErrorMessage(response);

        log.error("Feign error - Method: {}, Status: {}, Message: {}", methodKey, status, errorMessage);
        switch (status) {
            case 400:
                return new DownstreamServiceException(400,
                        errorMessage != null ? errorMessage : "Invalid request. Please check your input and try again.");

            case 404:
                return new ResourceNotFoundException(
                        errorMessage != null ? errorMessage : "The requested resource was not found.");

            case 409:
                return new ResourceConflictException(
                        toUserFriendlyConflictMessage(errorMessage));

            case 422:
                return new DownstreamServiceException(422,
                        errorMessage != null ? errorMessage : "The provided data could not be processed.");

            case 500:
                return new ServiceUnavailableException(
                        "Something went wrong on our end. Please try again later.");

            case 503:
                return new ServiceUnavailableException(
                        "The service is temporarily unavailable. Please try again shortly.");

            default:
                if (status >= 400 && status < 500) {
                    return new DownstreamServiceException(status,
                            errorMessage != null ? errorMessage : "Request could not be processed.");
                }
                return new ServiceUnavailableException(
                        "An unexpected error occurred. Please try again later.");
        }
    }//decode()


        /**
         * Extract errorMessage field from the producer's JSON error response.
         */
        private String extractErrorMessage (Response response){
            try {
                if (response.body() == null)
                    return null;
                InputStream bodyStream = response.body().asInputStream();
                JsonNode jsonNode = objectMapper.readTree(bodyStream);
                if (jsonNode.has("errorMessage")) {
                    return jsonNode.get("errorMessage").asText();
                }
            } catch (IOException e) {
                log.warn("Failed to parse Feign error response body", e);
            }
            return null;
        }//extractErrorMessage()

        /**
         * Convert technical conflict messages to user-friendly ones.
         */
        private String toUserFriendlyConflictMessage (String errorMessage){
            if (errorMessage != null && errorMessage.toLowerCase().contains("user already exists")) {
                return "An account with this username already exists. Please choose a different username or log in.";
            }//if
            return errorMessage != null ? errorMessage : "A conflict occurred with the current state of the resource.";
        }//toUserFriendlyConflictMessage()


    }//class
