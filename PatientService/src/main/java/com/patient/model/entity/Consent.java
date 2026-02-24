package com.patient.model.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.time.LocalDate;

public class Consent {
    @Id
    @GeneratedValue(generator = "gen3",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen3",sequenceName = "consent_seq",initialValue = 1,allocationSize=1)
    private Long consentId;
    private String consentType;
    private boolean isGiven;
    private LocalDate consentDate;
}
