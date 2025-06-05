package com.yogaapp.backend.service;

import com.yogaapp.backend.dto.*;
import com.yogaapp.backend.entity.User;
import com.yogaapp.backend.repository.UserRepository;
import com.yogaapp.backend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    public AuthResponseDto signup(RegisterRequestDto request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .build();
        userRepository.save(user);

        String token = jwtUtil.generateToken(user);

        logger.info("returning token from auth service signup method  " +token);
        return new AuthResponseDto(token);
    }

    public AuthResponseDto login(LoginRequestDto request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (Exception e) {
            logger.error("Authentication failed: {}", e.getMessage());
            throw e;
        }

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));


        String token = jwtUtil.generateToken(user);

        logger.info("returning token from auth service signup method "+token);
        return new AuthResponseDto(token);
    }
}