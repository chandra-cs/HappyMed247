package com.healthcare.service.interfaces;

import com.healthcare.exception.auth.EmailNotFoundException;
import com.healthcare.exception.auth.UsernameAlreadyExistsException;
import com.healthcare.model.dto.request.*;
import com.healthcare.model.dto.response.RegisterResponseDTO;
import com.healthcare.model.dto.response.ResendOtpResponseDto;
import jakarta.servlet.http.HttpServletRequest;

public interface IAuthService {

    public String login(LoginRequestDTO loginRequestDTO, HttpServletRequest httpServletRequest);
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO);
    public ActivateAccountResposeDTO activateAccount(ActivateAccountRequestDTO activateAccountRequestDTO) throws EmailNotFoundException;

    public ResendOtpResponseDto resendOtp(ResendOtpRequestDto resendOtpRequestDto);
}
