package com.yogaapp.backend.controller;

import com.yogaapp.backend.dto.TestingDto;
import com.yogaapp.backend.entity.Testing;
import com.yogaapp.backend.service.TestingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/testing")
public class TestingController {

    private final TestingService service;

    public TestingController(TestingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Testing> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Testing create(@RequestBody TestingDto dto) {
        return service.save(dto);
    }
}
