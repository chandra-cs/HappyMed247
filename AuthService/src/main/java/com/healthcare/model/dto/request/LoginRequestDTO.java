package com.healthcare.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {

    @NotBlank(message = "username cannot be empty")
    @Size(min=5, max = 20, message = "username must be between 5 & 20 characters")
    private String username;

    @NotBlank(message = "Password can not be empty")
    private String password;

}
