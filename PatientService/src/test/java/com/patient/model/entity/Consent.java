package com.patient.model.entity;

import org.joda.time.LocalDate;

public class Consent {
    private Long consentId;
    private String consentType;
    private boolean isGiven;
    private LocalDate consentDate;
}
