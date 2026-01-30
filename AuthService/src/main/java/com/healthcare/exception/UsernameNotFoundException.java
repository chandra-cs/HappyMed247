package com.healthcare.exception;


public class UsernameNotFoundException extends Exception {

    public UsernameNotFoundException() {

    }

    public UsernameNotFoundException(String message) {
        super(message);
    }

}
