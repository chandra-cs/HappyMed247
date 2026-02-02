package com.healthcare.listener;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthenticationEventListener {



    @EventListener
    public void onSuccess(AuthenticationSuccessEvent successEvent){
        /** ways to find authentication

       --------Using obj of AuthenticationSuccessEvent--------------
        Authentication authentication= successEvent.getAuthentication();


        ---------using SecurityContextHolder-------------
        Authentication = SecurityContextHolder.getContext().getAuthentication();(Authentication object)
        for username = authentication.getName();
        for password = authentication.getCredentials()

         ---Strategies for SecurityContext-----

         MODE_THREADLOCAL - MOST USE (Allows each thread to store it's own details in the security context)

         MODE_INHERITABLETHREADLOCAL (use if any @Async /@EnableAsync call is there as it creates another thread so this thread related context will be copy to the newly created thread )

         MODE_GLOBAL - make all the Thread of same application to see the same security instance

         // Steps to change the Strategy for  SecurityContext
         @Bean
         public InitializingBean initializingBean(){

            return ()-> SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);

         }


         */


        System.out.println("Authentication Success");
        System.out.println(getUsernameAndPassword());
        log.info("Login Successful for user : {}",successEvent.getAuthentication().getName());
    }

    public void onFailure(AbstractAuthenticationFailureEvent failureEvent){
        System.out.println("Authentication Failure");
        log.error("Login Failed for user : {} due to  :{}",failureEvent.getAuthentication().getName(),failureEvent.getException().getMessage());
    }

    public String getUsernameAndPassword(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Authentication Success :"+authentication.getName()+", Password Is:"+authentication.getCredentials().toString();
    }

    @PostConstruct
    public void testLog() {
        log.info("AuthenticationEventLogger initialized");
    }




}
