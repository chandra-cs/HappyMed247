package com.healthcare.service.interfaces;

import com.healthcare.exception.auth.UsernameAlreadyExistsException;
import com.healthcare.model.dto.request.LoginRequestDTO;
import com.healthcare.model.dto.request.RegisterRequestDTO;
import com.healthcare.model.dto.response.RegisterResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface IAuthService {

    public String login(LoginRequestDTO loginRequestDTO, HttpServletRequest httpServletRequest);
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO);

}
