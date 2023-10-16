package com.example.generator.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class TokenGeneratorService {

    public String generate(List<Integer> availableDigits) {
        Random random = new Random();
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int randomDigit = availableDigits.get(random.nextInt(availableDigits.size()));
            token.append(randomDigit);
            if ((i + 1) % 4 == 0 && i != 15) {
                token.append("-");
            }
        }
        return token.toString();
    }
}
