package com.yogaapp.backend.controller;

import com.yogaapp.backend.dto.EmailRequest;
import com.yogaapp.backend.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {
        boolean success = emailService.sendEmail(request.getEmail(), request.getMessage());
        return success ? ResponseEntity.ok("Email sent!") : ResponseEntity.status(500).body("Failed to send email");
    }
}
