package com.patient.repository;

import com.patient.model.entity.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAllergyRepository extends JpaRepository<Allergy, Long> {
    List<Allergy> findByPatientPatientId(Long patientId);
    Optional<Allergy> findByAllergyIdAndPatientPatientId(Long allergyId, Long patientId);
}