package com.yogaapp.backend.controller;
import java.util.Map;
import com.yogaapp.backend.dto.EmailRequest;
import com.yogaapp.backend.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contact/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request) {
        boolean success = emailService.sendEmail(request.getEmail(), request.getMessage());

        if (success) {
            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Email sent!"
            ));
        } else {
            return ResponseEntity.status(500).body(Map.of(
                    "success", false,
                    "message", "Failed to send email"
            ));
        }
    }
}
