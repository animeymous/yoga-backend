package com.yogaapp.backend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class EmailService {

    private static final String API_URL = "https://api.brevo.com/v3/smtp/email";

    private final String apiKey;

    public EmailService(@Value("${brevo.api.key}") String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean sendEmail(String toEmail, String message) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("api-key", apiKey);

            Map<String, Object> emailData = new HashMap<>();
            emailData.put("sender", Map.of("name", "Yoga App", "email", "workpurpose619@gmail.com"));
            emailData.put("to", new Object[]{Map.of("email", toEmail)});
            emailData.put("subject", "Reply from Yoga App");
            emailData.put("htmlContent", "<p>" + message + "</p>");

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(emailData, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(API_URL, request, String.class);

            log.info("Brevo Response: {}", response.getBody());
            return response.getStatusCode().is2xxSuccessful();

        } catch (Exception e) {
            log.error("Failed to send email: {}", e.getMessage());
            return false;
        }
    }
}