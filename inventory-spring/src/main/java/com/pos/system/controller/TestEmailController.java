package com.pos.system.controller;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
@CrossOrigin()
public class TestEmailController {
    private final JavaMailSender mailSender;

    @Autowired
    public TestEmailController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @GetMapping("/test-email")
    public String testEmail() {
        try {
            // Cast JavaMailSender to JavaMailSenderImpl to access testConnection()
            if (mailSender instanceof JavaMailSenderImpl) {
                ((JavaMailSenderImpl) mailSender).testConnection(); // Validate connection
                return "SMTP connection successful!";
            } else {
                return "Cannot test connection: mailSender is not an instance of JavaMailSenderImpl.";
            }
        } catch (MessagingException e) {
            return "SMTP connection failed: " + e.getMessage();
        }
    }
}
