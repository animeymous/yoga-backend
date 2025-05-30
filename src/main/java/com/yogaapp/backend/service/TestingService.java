package com.yogaapp.backend.service;

import com.yogaapp.backend.dto.TestingDto;
import com.yogaapp.backend.entity.Testing;
import com.yogaapp.backend.repository.TestingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestingService {
    private final TestingRepository repository;

    public TestingService(TestingRepository repository){
        this.repository = repository;
    }

    public List<Testing> getAll(){
        return repository.findAll();
    }

    public Testing save(TestingDto dto){
        Testing entity = new Testing();
        entity.setMessage(dto.getMessage());
        entity.setRole(dto.getRole());
        return repository.save(entity);
    }
}
