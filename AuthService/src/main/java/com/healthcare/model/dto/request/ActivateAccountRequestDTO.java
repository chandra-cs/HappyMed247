package com.healthcare.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivateAccountRequestDTO {

    private String email;
    private String password;
    private String otp;

}
