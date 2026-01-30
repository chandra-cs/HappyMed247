package com.healthcare.dummy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.healthcare.model.entity.Role;
import com.healthcare.model.entity.User;
import com.healthcare.repository.IRoleRepository;
import com.healthcare.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DummyDataLoader implements CommandLineRunner {
	
    private final IRoleRepository roleRepo;
    private final IUserRepository userRepo;
    private final PasswordEncoder encoder;

    @Override
    public void run(String... args) {

        Role admin = roleRepo.save(new Role(null, "ADMIN"));
        Role doctor = roleRepo.save(new Role(null, "DOCTOR"));

        /*
        User admin_role = new User();
        admin_role.setUsername("admin");
        admin_role.setPassword(encoder.encode("admin123"));
        admin_role.getRoles().add(admin);
        */
        
        User doctor_role = new User();
        doctor_role.setUsername("dummy_doctor");
        doctor_role.setPassword(encoder.encode("doctor123"));
        doctor_role.getRoles().add(doctor);
        
        

        userRepo.save(doctor_role);
    }
}

