package com.patient.repository;

import com.patient.model.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
}