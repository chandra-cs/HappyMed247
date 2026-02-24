package com.patient.model.entity;

import jakarta.persistence.*;

@Entity
public class MedicalDocument {

    @Id
    @GeneratedValue(generator = "gen4",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "gen4",sequenceName = "medical_doc_seq",initialValue = 1, allocationSize = 1)
    private Long id;

    private String fileName;
    private String filePath;

}
