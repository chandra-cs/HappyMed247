package com.patient.repository;

import com.patient.model.entity.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmergencyContactRepository extends JpaRepository<EmergencyContact, Long> {
}