package com.healthcare.controller;

import com.healthcare.model.dto.request.LoginRequestDTO;
import com.healthcare.model.dto.request.RegisterRequestDTO;
import com.healthcare.model.dto.response.LoginResponseDTO;
import com.healthcare.model.dto.response.RegisterResponseDTO;
import com.healthcare.service.interfaces.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth/v1")
@RequiredArgsConstructor
public class AuthController {


    private final IAuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO req) {

        //get the Jwt token from authService
        String token = authService.login(req.getUsername(), req.getPassword());

        //send it through LoginResponseDto;
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("accessToken", token);

        return LoginResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Successfully logged in")
                .accessToken(tokenMap)
                .build();
    }


    @PostMapping("/register")
    public RegisterResponseDTO register(@RequestBody RegisterRequestDTO req) {

        return authService.register(req);
    }


}