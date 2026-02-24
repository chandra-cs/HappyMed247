package com.healthcare.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleCreationRequestDTO {

    @NotBlank(message = "Role name must not be empty")
    private String roleName;

}
