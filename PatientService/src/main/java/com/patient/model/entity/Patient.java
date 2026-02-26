package com.patient.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(generator ="gen1", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen1",sequenceName = "patient_seq", initialValue = 100, allocationSize = 1)
    private Long patientId;



    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    private String gender;
    private String address;
    private String city;
    private String state;

    private String insuranceProvider;
    private String insuranceNumber;
    private String insuranceType;

    @ToString.Exclude
    @OneToOne(mappedBy = "patient",fetch = FetchType.LAZY)
    private EmergencyContact emergencyContact;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "patient", orphanRemoval = true)
    private List<MedicalHistory> medicalHistory = new ArrayList<>();


    @ToString.Exclude
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Allergy> allergy = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Visit> visit = new ArrayList<>();


    @ToString.Exclude
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MedicalDocument> medicalDocument = new ArrayList<>();


    @ToString.Exclude
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Consent> consent = new ArrayList<>();


    //meta data
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    //adding helper methods to keep bi-directional relationships in sync

    public void addNewMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory.add(medicalHistory);
        medicalHistory.setPatient(this);
    }

    public void removeMedicalHistory(MedicalHistory medicalHistory) {
        this.medicalHistory.remove(medicalHistory);
        medicalHistory.setPatient(null);
    }





}
