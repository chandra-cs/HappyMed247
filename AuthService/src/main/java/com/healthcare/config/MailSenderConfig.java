package com.healthcare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailSenderConfig {

    @Bean
    public JavaMailSender getMailSender() {
        return new JavaMailSenderImpl();
    }

}
