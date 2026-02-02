package com.healthcare.service;

import com.healthcare.model.entity.Role;
import com.healthcare.model.entity.User;
import com.healthcare.repository.IUserRepository;
import com.healthcare.utility.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {


    private final IUserRepository userRepo;

    private final PasswordEncoder encoder;

    private final JwtProvider jwtProvider;

    public String login(String username, String password) {


        /**
        User user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));


        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
         */

        //for testing purpose
        Role role = new Role();
        role.setId(1);
        role.setName("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User(101,username,"test@gmail.com",password,roles,true,false);

        return jwtProvider.generateToken(user);
    }


}
