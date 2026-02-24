package com.patient.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "medical_history")
public class MedicalHistory {

    @Id
    @SequenceGenerator(name = "gen5",sequenceName = "med_history_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator = "gen5",strategy = GenerationType.SEQUENCE)
    private Long medicalHistoryId;
    private String condition;
    private String notes;
    private LocalDate startDate;
    private LocalDate endDate;

    //foreign key related config
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;



}
