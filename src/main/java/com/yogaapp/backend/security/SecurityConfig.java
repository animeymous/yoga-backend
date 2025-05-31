package com.yogaapp.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // disable CSRF for simplicity (adjust as needed)
                .authorizeHttpRequests(auth -> auth
                        // Testing API rules
                        .requestMatchers(HttpMethod.GET, "/api/v1/testing").permitAll()         // public GET testing
                        .requestMatchers(HttpMethod.POST, "/api/v1/testing").hasRole("ADMIN") // admin POST testing

                        // Contact API rules
                        .requestMatchers(HttpMethod.POST, "/api/v1/contact").permitAll()      // public POST contact
                        .requestMatchers(HttpMethod.GET, "/api/v1/contact").hasRole("ADMIN")  // admin GET contact

                        // all other endpoints require authentication
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()) // basic auth for protected endpoints
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin123") // {noop} disables password encoding
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }
}