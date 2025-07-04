package com.yogaapp.backend.dto;

import com.yogaapp.backend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDto {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}