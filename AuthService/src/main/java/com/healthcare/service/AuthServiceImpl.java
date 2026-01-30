package com.healthcare.service;

import com.healthcare.model.entity.User;
import com.healthcare.repository.IUserRepository;
import com.healthcare.utility.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {


    private final IUserRepository userRepo;

    private final PasswordEncoder encoder;

    private final JwtProvider jwtProvider;

    public String login(String username, String password) {

        User user = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));


        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtProvider.generateToken(user);
    }


}
