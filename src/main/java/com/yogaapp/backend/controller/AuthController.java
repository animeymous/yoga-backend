package com.yogaapp.backend.controller;

import com.yogaapp.backend.dto.*;
import com.yogaapp.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public AuthResponseDto signup(@RequestBody RegisterRequestDto request) {
        System.out.println(request);
        return authService.signup(request);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginRequestDto request) {
        System.out.println(request);
        return authService.login(request);
    }
}