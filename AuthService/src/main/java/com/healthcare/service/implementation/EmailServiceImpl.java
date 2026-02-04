package com.healthcare.service.implementation;


import com.healthcare.service.interfaces.IEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;

import java.io.File;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements IEmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private   String senderMail;


    @Async
    public void sendOtpEmail(String toEmail, String otp) throws MessagingException  {

        /**
         *
         * Working fine but having drawback like can not send attachments like images or , Pdf files for any instruction or any files
         * substitution : MimeMessageHelper
         *
           SimpleMailMessage message = new SimpleMailMessage();
           message.setTo(toEmail);
           message.setSubject("Registration OTP for HappyMed247");
           message.setText(buildOtpEmailBody(otp));
           mailSender.send(message);
       */


        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(toEmail);
        helper.setSubject("Registration OTP for HappyMed247");
        helper.setText(buildOtpEmailBody(otp), false);
        helper.setFrom(senderMail);

        /*
        ClassPathResource resource = new ClassPathResource("image/HappyMedBanner.png");
        helper.addAttachment("banner.img",resource);
        */
        mailSender.send(mimeMessage);

    }


    private String buildOtpEmailBody(String otp) {
        return """
                Hello,

                Your One-Time Password (OTP) for HappyMed247 is:

                OTP: %s

                This OTP is valid for 10 minutes.
                Please do not share this OTP with anyone.

                Regards,
                HappyMed247 Team
                """.formatted(otp);
    }
}


