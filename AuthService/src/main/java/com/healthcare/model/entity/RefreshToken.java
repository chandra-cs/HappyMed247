package com.healthcare.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
public class RefreshToken {


        @Id
        @GeneratedValue(generator = "sq3",strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "sq3",sequenceName = "refresh_token_sq",initialValue=1,allocationSize=1)
        private Long id;

        @ManyToOne
        private User user;

        private String token;
        private Instant expiry;
        private boolean revoked;


}
