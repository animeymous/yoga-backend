package com.yogaapp.backend.controller.v1;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HelloControllerV1 {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from API version 1!";
    }
}
