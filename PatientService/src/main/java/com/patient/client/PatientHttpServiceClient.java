package com.patient.client;

import com.patient.model.dto.client.AuthServiceRegisterRequestDTO;
import com.patient.model.dto.client.AuthServiceRegisterResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

/**
 *
 * Have to remove it after testing as i will implement kafka after this
 *
 */

@HttpExchange(url = "${auth-service.url}")
public interface PatientHttpServiceClient {

    @PostExchange
    public AuthServiceRegisterResponseDTO register(@RequestBody AuthServiceRegisterRequestDTO request);

}
