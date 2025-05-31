package com.yogaapp.backend.controller;

import com.yogaapp.backend.dto.ContactDto;
import com.yogaapp.backend.entity.Contact;
import com.yogaapp.backend.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public Contact createContact(@RequestBody ContactDto dto) {
        return contactService.save(dto);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAll();
    }
}