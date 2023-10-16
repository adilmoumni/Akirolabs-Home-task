package com.example.validator.service;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TokenValidatorServiceTest {

    private final TokenValidatorService service = new TokenValidatorService();

    @Test
    public void testValidateValidToken() {
        assertTrue(service.validate("3890-3017-8664-6314")); // Example of a valid token
    }

    @Test
    public void testValidateInvalidToken() {
        assertFalse(service.validate("1234-5678-9012-3456")); // Example of an invalid token
    }
}
