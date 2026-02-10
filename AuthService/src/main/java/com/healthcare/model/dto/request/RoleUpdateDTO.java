package com.healthcare.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleUpdateDTO {

    private Integer roleId;

    private String roleName;

    private String newRoleName;

}
