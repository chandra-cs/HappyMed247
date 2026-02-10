package com.healthcare.exception.auth;


public class UsernameNotFoundException extends Exception {

    public UsernameNotFoundException() {

    }

    public UsernameNotFoundException(String message) {
        super(message);
    }

}
