package com.healthcare.controller;

import com.healthcare.model.dto.request.LoginRequestDTO;
import com.healthcare.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final IAuthService authService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequestDTO req) {
        String token = authService.login(req.getUsername(), req.getPassword());
        return Map.of("accessToken", token);
    }
}