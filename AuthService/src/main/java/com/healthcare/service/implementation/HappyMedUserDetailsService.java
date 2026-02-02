package com.healthcare.service.implementation;

import com.healthcare.exception.EmailNotFoundException;
import com.healthcare.model.entity.User;
import com.healthcare.repository.IUserRepository;
import com.healthcare.service.interfaces.IHappyMedUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HappyMedUserDetailsService implements UserDetailsService, IHappyMedUserDetailsService {

    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByEmail(String email) throws EmailNotFoundException {

        User user = userRepository.findByEmail(email).orElseThrow(() -> new EmailNotFoundException("Email not found check mail id: " + email));
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRoles().toString()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRoles().toString()));

        return new org.springframework.security.core.userdetails.User((user.getUsername()), user.getPassword(), authorities);
    }
}
