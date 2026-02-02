package com.healthcare.service.interfaces;

import com.healthcare.exception.EmailNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

public interface IHappyMedUserDetailsService {

    //custom user loading logic
    public UserDetails loadUserByEmail(String email) throws EmailNotFoundException;

}
