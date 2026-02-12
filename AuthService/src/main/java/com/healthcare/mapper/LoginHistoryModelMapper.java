package com.healthcare.mapper;

import com.healthcare.model.dto.request.LoginHistoryDTO;
import com.healthcare.model.entity.LoginHistory;

import java.time.Instant;

public class LoginHistoryModelMapper {

    public static LoginHistory mapToLoginHistory(LoginHistoryDTO loginHistoryDTO) {
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setUserId(loginHistoryDTO.getUserId());
        loginHistory.setIpAddress(loginHistoryDTO.getIpAddress());
        loginHistory.setUserAgent(loginHistoryDTO.getUserAgent());
        loginHistory.setSuccess(loginHistoryDTO.getSuccessStatus());
        loginHistory.setLoginTime(Instant.now());
        return loginHistory;
    }

}
