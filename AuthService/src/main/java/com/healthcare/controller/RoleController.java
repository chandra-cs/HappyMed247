package com.healthcare.controller;

import com.healthcare.model.dto.request.RoleCreationRequestDTO;
import com.healthcare.model.dto.request.RoleUpdateDTO;
import com.healthcare.model.dto.response.RoleCreationResponseDTO;
import com.healthcare.model.entity.Role;
import com.healthcare.service.interfaces.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/all-roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> allRoles = roleService.getAllRoles();
        return new ResponseEntity<>(allRoles, HttpStatus.OK);
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<Role> getRoleByRoleId(@PathVariable Integer id) {
        return  new ResponseEntity<>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @PatchMapping("/update-role")
    public ResponseEntity<String> updateRole(@RequestBody RoleUpdateDTO role) {
        String updateMsg = roleService.updateRole(role);
        return new ResponseEntity<>(updateMsg, HttpStatus.OK);
    }

    @DeleteMapping("/delete?id")
    public ResponseEntity<String> deleteRoleById(@RequestParam Integer id) {
        String deleteMsg = roleService.deleteRoleById(id);
        return new ResponseEntity<>(deleteMsg, HttpStatus.OK);
    }


}//class
