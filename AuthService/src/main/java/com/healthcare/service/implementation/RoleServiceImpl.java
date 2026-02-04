package com.healthcare.service.implementation;

import com.healthcare.exception.RoleAlreadyExistsException;
import com.healthcare.model.dto.request.RoleCreationRequestDTO;
import com.healthcare.model.dto.response.RoleCreationResponseDTO;
import com.healthcare.model.entity.Role;
import com.healthcare.repository.IRoleRepository;
import com.healthcare.service.interfaces.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
}
