package com.healthcare.repository;

import com.healthcare.model.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuditLogRepository extends JpaRepository<AuditLog,Integer> {
}
