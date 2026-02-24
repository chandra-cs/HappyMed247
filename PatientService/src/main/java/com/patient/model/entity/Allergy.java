package com.patient.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Table(name = "allergy")
public class Allergy {

    @Id
    @GeneratedValue(generator = "gen2",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen2",sequenceName = "allergy_seq",allocationSize=1,initialValue=1)
    private Long allergyId;

    private String allergyName;
    private String reaction;
    private String severity;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

}
