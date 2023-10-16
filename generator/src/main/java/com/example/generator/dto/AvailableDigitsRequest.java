package com.example.generator.dto;

import java.util.List;

public class AvailableDigitsRequest {
    private List<Integer> availableDigits;

    public List<Integer> getAvailableDigits() {
        return availableDigits;
    }

    public void setAvailableDigits(List<Integer> availableDigits) {
        this.availableDigits = availableDigits;
    }
}
