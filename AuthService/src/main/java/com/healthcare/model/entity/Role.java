package com.healthcare.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(generator = "sq2",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sq2",sequenceName = "user_role_seq",allocationSize=1,initialValue=1)
    private Integer id;

    @Column(unique = true)
    private String name;
}

