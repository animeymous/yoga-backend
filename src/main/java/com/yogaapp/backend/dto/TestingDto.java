package com.yogaapp.backend.dto;

import com.yogaapp.backend.entity.Role;
import  lombok.Data;

@Data
public class TestingDto {
    private String message;
    private Role role;
}
