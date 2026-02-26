package com.patient.client;

import com.patient.model.dto.client.AuthServiceRegisterRequestDTO;
import com.patient.model.dto.client.AuthServiceRegisterResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "AuthService",
        url = "${auth-service.url}"
)
public interface IAuthServiceFeignClient {

    @PostMapping("/auth/v1/register")
    public AuthServiceRegisterResponseDTO register(@RequestBody AuthServiceRegisterRequestDTO request);

}
