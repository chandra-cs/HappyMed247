package com.healthcare.service.implementation;

import com.healthcare.model.entity.AuditLog;
import com.healthcare.repository.IAuditLogRepository;
import com.healthcare.service.interfaces.IAuditLogService;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
public class AuditLogServiceImpl implements IAuditLogService {


    private final IAuditLogRepository auditLogRepository;



    public void log(Integer userId, String action, String endpoint) {

        AuditLog auditLog = new AuditLog();
        auditLog.setUserId(userId);
        auditLog.setAction(action);
        auditLog.setEndpoint(endpoint);
        auditLog.setTimestamp(Instant.now());

        auditLogRepository.save(auditLog);
    }

}
