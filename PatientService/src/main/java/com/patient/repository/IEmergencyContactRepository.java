package com.patient.repository;

import com.patient.model.entity.EmergencyContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmergencyContactRepository extends JpaRepository<EmergencyContact, Long> {

    Optional<EmergencyContact> findByPatientPatientId(Long patientId);

}