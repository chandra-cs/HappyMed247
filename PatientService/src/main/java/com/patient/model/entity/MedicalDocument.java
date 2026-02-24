package com.patient.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "medical_document")
@Data
public class MedicalDocument {

    @Id
    @GeneratedValue(generator = "gen4",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen4",sequenceName = "medical_doc_seq",initialValue = 1, allocationSize = 1)
    private Long id;

    private String fileName;
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;

}
