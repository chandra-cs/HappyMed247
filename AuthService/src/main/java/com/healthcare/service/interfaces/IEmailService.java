package com.healthcare.service.interfaces;

import jakarta.mail.MessagingException;

public interface IEmailService {


        public void sendOtpEmail(String toEmail, String otp) throws MessagingException;

}