package com.patient.model.entity;

import jakarta.persistence.*;

@Entity
public class Allergy {

    @Id
    @GeneratedValue(generator = "gen2",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen2",sequenceName = "allergy_seq",allocationSize=1,initialValue=1)
    private Long allergyId;

    private String allergyName;
    private String reaction;
    private String severity;

}
