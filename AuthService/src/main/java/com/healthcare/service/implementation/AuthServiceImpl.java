package com.healthcare.service.implementation;

import com.healthcare.exception.PasswordMismatchException;
import com.healthcare.exception.UsernameAlreadyExistsException;
import com.healthcare.mapper.RegisterModelMapper;
import com.healthcare.model.dto.request.RegisterRequestDTO;
import com.healthcare.model.dto.response.RegisterResponseDTO;
import com.healthcare.model.entity.Role;
import com.healthcare.model.entity.User;
import com.healthcare.repository.IRoleRepository;
import com.healthcare.repository.IUserRepository;
import com.healthcare.service.interfaces.IAuthService;
import com.healthcare.utility.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements IAuthService {


    private final IUserRepository userRepo;

    private final IRoleRepository roleRepo;

    private final PasswordEncoder encoder;

    private final JwtProvider jwtProvider;

    private final HappyMedUserDetailsService  userDetailsService;

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

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO registerRequestDTO) throws UsernameAlreadyExistsException {

        //check whether user exist by email or username
        if(!registerRequestDTO.getPassword().equals(registerRequestDTO.getConfirmPassword())) {
            throw new PasswordMismatchException("Password and Confirm Password must be same");
        }
        else if (userRepo.findByUsername(registerRequestDTO.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("User already Exists having username:"+registerRequestDTO.getUsername());
        } else if (userRepo.findByEmail(registerRequestDTO.getEmail()).isPresent()) {
            throw new UsernameAlreadyExistsException("User already Exists having email:"+registerRequestDTO.getEmail());
        }

        //use mapper class to map DTO into User object
        RegisterModelMapper registerModelMapper = new RegisterModelMapper();
        User user = registerModelMapper.mapToRegisterObj(registerRequestDTO);

        //encode the password Using BCryptPasswordEncoder
        user.setPassword(encoder.encode(registerRequestDTO.getPassword()));

        //save the user object


        return null;
    }


}
