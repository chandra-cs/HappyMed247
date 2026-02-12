package com.healthcare.service.implementation;

import com.healthcare.mapper.LoginHistoryModelMapper;
import com.healthcare.model.dto.request.LoginHistoryDTO;
import com.healthcare.model.entity.LoginHistory;
import com.healthcare.repository.ILoginHistoryRepository;
import com.healthcare.service.interfaces.ILoginHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginHistoryServiceImpl implements ILoginHistoryService {

    private final ILoginHistoryRepository loginHistoryRepository;

    @Override
    public void recordLogin(LoginHistoryDTO loginHistoryDTO) {

        //map the LoginHistoryDTO with LoginHistory

        LoginHistory loginHistory = LoginHistoryModelMapper.mapToLoginHistory(loginHistoryDTO);

        //save into table
        loginHistoryRepository.save(loginHistory);


    }
}
