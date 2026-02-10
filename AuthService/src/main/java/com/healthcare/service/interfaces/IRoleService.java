package com.healthcare.service.interfaces;

import com.healthcare.model.dto.request.RoleCreationRequestDTO;
import com.healthcare.model.dto.request.RoleUpdateDTO;
import com.healthcare.model.dto.response.RoleCreationResponseDTO;
import com.healthcare.model.entity.Role;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRoleService {

    public RoleCreationResponseDTO createRole(RoleCreationRequestDTO roleCreationRequestDTO);
    public List<Role> getAllRoles();

    public Role getRoleById(Integer id);

    public String updateRole(RoleUpdateDTO role);

    public String deleteRoleById(Integer id);

}
