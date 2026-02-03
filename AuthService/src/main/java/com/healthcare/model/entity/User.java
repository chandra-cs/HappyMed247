package com.healthcare.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sq1")
    @SequenceGenerator(sequenceName = "users_sequence",name = "sq1", allocationSize=1,initialValue=1)
    private Integer id;

    @Column(unique = true)
    private String username;

    @Column(unique = true,name="email",length = 50)
    private String email;


    private String password;





    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<Role>();



    private boolean active = true;
    private boolean locked = false;


}
