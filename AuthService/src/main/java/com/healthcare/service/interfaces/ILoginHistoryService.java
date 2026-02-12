package com.healthcare.service.interfaces;

import com.healthcare.model.dto.request.LoginHistoryDTO;

public interface ILoginHistoryService {

    public void recordLogin(LoginHistoryDTO loginHistoryDTO);


}
