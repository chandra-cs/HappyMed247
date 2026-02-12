package com.healthcare.service.interfaces;

public interface IAuditLogService {

    public void log(Integer userId, String action, String endpoint);

}
