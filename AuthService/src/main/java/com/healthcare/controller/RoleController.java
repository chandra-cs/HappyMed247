package com.healthcare.controller;

import com.healthcare.model.dto.request.RoleCreationRequestDTO;
import com.healthcare.model.dto.response.RoleCreationResponseDTO;
import com.healthcare.service.interfaces.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role-api/v1")
@RequiredArgsConstructor
public class RoleController {


    private final IRoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<RoleCreationResponseDTO> createRole(@RequestBody RoleCreationRequestDTO roleCreationRequestDTO) {
        RoleCreationResponseDTO roleCreationResponse = roleService.createRole(roleCreationRequestDTO);
        return new ResponseEntity<>(roleCreationResponse, HttpStatus.OK);
    }


}
