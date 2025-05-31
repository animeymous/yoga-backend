package com.yogaapp.backend.dto;

import lombok.Data;

@Data
public class EmailRequest {
    private String email;
    private String message;
}