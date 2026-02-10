package com.healthcare.service.interfaces;

import com.healthcare.exception.auth.UsernameAlreadyExistsException;
import com.healthcare.model.dto.request.RegisterRequestDTO;
import com.healthcare.model.dto.response.RegisterResponseDTO;

public interface IAuthService {

    public String login(String username, String password);
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO) throws UsernameAlreadyExistsException;

}
