package com.patient.repository;

import com.patient.model.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVisitRepository extends JpaRepository<Visit, Long> {
}