package com.example.inventorymanagementsystemamazon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public boolean validatedToken(String token) {
        return !token.isEmpty();
    }
}
