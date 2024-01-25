package com.example.g;

public class SimpleCalculator implements Calculator {
    private int parse(String numbers) {
        if (numbers.isEmpty()) return 0;

        return Integer.parseInt(numbers);
    }
    @Override
    public int add(String numbers) {
        var numberChanks = parse(numbers);
        return numberChanks;
    }
}
