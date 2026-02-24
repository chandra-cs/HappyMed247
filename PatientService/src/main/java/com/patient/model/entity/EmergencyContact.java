package com.patient.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "emergency_contact")
public class EmergencyContact {

    @Id
    @GeneratedValue(generator = "gen7", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen7",sequenceName = "emergency_contact_sq",initialValue=1,allocationSize=1)
    private Long emergencyContactId;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String emergencyContactEmail;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;

}
