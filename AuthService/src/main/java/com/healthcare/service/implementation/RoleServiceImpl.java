package com.healthcare.service.implementation;

import com.healthcare.exception.role.RoleAlreadyExistsException;
import com.healthcare.exception.role.RoleNameMismatchException;
import com.healthcare.exception.role.RoleNameNotFoundException;
import com.healthcare.exception.role.SameRoleUpdationException;
import com.healthcare.model.dto.request.RoleCreationRequestDTO;
import com.healthcare.model.dto.request.RoleUpdateDTO;
import com.healthcare.model.dto.response.RoleCreationResponseDTO;
import com.healthcare.model.entity.Role;
import com.healthcare.repository.IRoleRepository;
import com.healthcare.service.interfaces.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository roleRepository;

    @Override
    public RoleCreationResponseDTO createRole(RoleCreationRequestDTO roleCreationRequestDTO) {

        String roleName = roleCreationRequestDTO.getRoleName().toUpperCase();

        boolean isPresent = roleRepository.findByName(roleName).isPresent();
        if (isPresent) {
            throw new RoleAlreadyExistsException("Role Already Exists, Please Check Role name : "+roleName);
        }

        Role role = new Role();
        role.setName(roleName);
        roleRepository.save(role);

        return RoleCreationResponseDTO.builder()
                .role(roleName.toUpperCase())
                .description("Role Successfully Created")
                .build();

    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Integer id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RoleNameNotFoundException("Role Not Found with associated id : " + id));
        return role;
    }

    @Override
    public String updateRole(RoleUpdateDTO roleUpdateDTO) {
        Role roleById = getRoleById(roleUpdateDTO.getRoleId());
        if(roleUpdateDTO.getRoleName().equalsIgnoreCase(roleUpdateDTO.getNewRoleName())){
            throw new SameRoleUpdationException("Please Provide a new role name, old role name and new role name can not be same.");
        }
        else if(!roleById.getName().equals(roleUpdateDTO.getRoleName())) {
            throw new RoleNameMismatchException("Please provide valid rolename, Your provided role name : " + roleUpdateDTO.getRoleName());
        }
        else if(roleRepository.findByName(roleUpdateDTO.getNewRoleName()).isPresent()) {
            throw new RoleAlreadyExistsException("The New Role You are Providing Already Exists, Please Check Role name : "+roleUpdateDTO.getNewRoleName());
        }


        //save the new role name
        roleById.setName(roleUpdateDTO.getNewRoleName());
        roleRepository.save(roleById);

        return "Role Successfully Updated";
    }

    @Override
    public String deleteRoleById(Integer id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RoleNameNotFoundException("Role Not Found with associated id : " + id));
        roleRepository.delete(role);
        return "role Successfully deleted";
    }


}
