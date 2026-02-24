package com.patient.repository;

import com.patient.model.entity.Consent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsentRepository extends JpaRepository<Consent, Long> {
}