package com.yogaapp.backend.service;

import com.yogaapp.backend.dto.ContactDto;
import com.yogaapp.backend.entity.Contact;
import com.yogaapp.backend.repository.ContactRepository;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact save(ContactDto dto) {
        Contact contact = Contact.builder()
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .subject(dto.getSubject())
                .message(dto.getMessage())
                .build();

        log.info("saved contact");
        return contactRepository.save(contact);
    }

    public List<Contact> getAll() {
        log.info("returning all contacts");
        return contactRepository.findAll();
    }
}
