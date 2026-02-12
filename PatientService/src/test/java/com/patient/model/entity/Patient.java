package com.patient.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import java.util.List;

@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(generator ="gen1", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen1",sequenceName = "patient_seq", initialValue = 100, allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;

    private String insuranceProvider;
    private String insuranceNumber;
    private String insuranceType;

    private String emergencyContactName;
    private String emergencyContactPhone;
    private String emergencyContactEmail;

    private List<MedicalHistory> medicalHistory;
    private List<Allergy> allergy;
    private List<Visit> visit;
    private List<MedicalDocument> medicalDocument;
    private List<Consent> consent;


    //meta data
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
