package com.patient.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(generator = "gen6",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen6",sequenceName = "visit_sq",initialValue = 1,allocationSize=1)
    private Long visitId;

    private LocalDate visitDate;

    //private Doctor doctorAssigned;
    private String notes;

    private String reason;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;

}
