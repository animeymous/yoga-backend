package com.yogaapp.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Testing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Enumerated(EnumType.STRING)
    private Role role;
}

