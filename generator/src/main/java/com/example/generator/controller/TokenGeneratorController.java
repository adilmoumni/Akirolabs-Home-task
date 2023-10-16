package com.example.generator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.generator.service.TokenGeneratorService;
import com.example.generator.dto.AvailableDigitsRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TokenGeneratorController {

    @Autowired
    private TokenGeneratorService tokenGeneratorService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateToken(@RequestBody AvailableDigitsRequest request) {
        String token = tokenGeneratorService.generate(request.getAvailableDigits());
        return ResponseEntity.ok(token);
    }
}
