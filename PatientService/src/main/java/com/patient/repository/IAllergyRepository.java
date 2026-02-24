package com.patient.repository;

import com.patient.model.entity.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAllergyRepository extends JpaRepository<Allergy, Long> {
}