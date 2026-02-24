package com.patient.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.model.entity.Visit;

@Repository
public interface IVisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findByPatientPatientId(Long patientId);
    Optional<Visit> findByVisitIdAndPatientPatientId(Long visitId, Long patientId);
}