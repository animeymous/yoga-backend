package com.yogaapp.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDto {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String subject;
    private String message;
}