package com.example.generator.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
public class TokenGeneratorServiceTest {

    private final TokenGeneratorService service = new TokenGeneratorService();

    @Test
    public void testGenerateTokenWithSelectedDigits() {
        List<Integer> digits = Arrays.asList(2, 4, 7, 9, 0);
        String token = service.generate(digits);

        // Check token format
        assertTrue(token.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}"));

        // Check token contains only the selected digits
        for (char ch : token.replace("-", "").toCharArray()) {
            assertTrue(digits.contains(Character.getNumericValue(ch)));
        }

    }
}
