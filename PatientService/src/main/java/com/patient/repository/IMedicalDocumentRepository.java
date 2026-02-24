package com.patient.repository;

import com.patient.model.entity.MedicalDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicalDocumentRepository extends JpaRepository<MedicalDocument, Long> {
}