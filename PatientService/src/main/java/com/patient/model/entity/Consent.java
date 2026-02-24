package com.patient.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "consent")
@Data
public class Consent {
    @Id
    @GeneratedValue(generator = "gen3",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen3",sequenceName = "consent_seq",initialValue = 1,allocationSize=1)
    private Long consentId;
    private String consentType;
    private boolean isGiven;
    private LocalDate consentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;

}
