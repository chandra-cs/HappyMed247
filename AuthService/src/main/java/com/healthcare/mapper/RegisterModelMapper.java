package com.healthcare.mapper;

import com.healthcare.model.dto.request.RegisterRequestDTO;
import com.healthcare.model.entity.Role;
import com.healthcare.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;


public class RegisterModelMapper {



    public User mapToRegisterObj(RegisterRequestDTO registerRequestDTO) {
        User user = new User();
        user.setUsername(registerRequestDTO.getUsername());
        user.setPassword(registerRequestDTO.getPassword());
        user.setEmail(registerRequestDTO.getEmail());

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName(registerRequestDTO.getRole());
        roles.add(role);
        user.setRoles(roles);

        return user;
    }


}
