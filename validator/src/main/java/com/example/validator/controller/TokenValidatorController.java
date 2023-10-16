package com.example.validator.controller;

import com.example.validator.dto.TokenValidationRequest;
import com.example.validator.service.TokenValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TokenValidatorController {

    @Autowired
    private TokenValidatorService tokenValidatorService;

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestBody TokenValidationRequest request) {
        boolean isValid = tokenValidatorService.validate(request.getToken());
        return ResponseEntity.ok(isValid);
    }
}
