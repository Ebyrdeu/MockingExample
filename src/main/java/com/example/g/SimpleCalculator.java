package com.example.g;

public class SimpleCalculator implements Calculator {
    private int parse(String numbers) {
        if (numbers.isEmpty()) return 0;
        String[]  chanks = numbers.split(",");
        int numberOne = Integer.parseInt(chanks[0]);
        int numberTwo = Integer.parseInt(chanks[1]);
        return 1;
    }
    @Override
    public int add(String numbers) {
        var numberChanks = parse(numbers);
        return numberChanks;
    }
}
