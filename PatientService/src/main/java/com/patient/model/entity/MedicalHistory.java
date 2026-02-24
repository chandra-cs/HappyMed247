package com.patient.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class MedicalHistory {

    @Id
    @SequenceGenerator(name = "gen5",sequenceName = "med_history_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "gen5",strategy = GenerationType.SEQUENCE)
    private Long medicalHistoryId;
    private String condition;
    private String notes;
    private LocalDate startDate;
    private LocalDate endDate;



}
