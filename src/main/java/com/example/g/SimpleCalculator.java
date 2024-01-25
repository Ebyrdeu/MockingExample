package com.example.g;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;

public class SimpleCalculator implements Calculator {
    private List<Integer> parse(String numbers) {
        if (numbers.isEmpty()) return List.of(0);
        if (numbers.length() == 1) return List.of(parseInt(numbers));
        String[] chunks  = numbers.split(",");
        int chunkOne = parseInt(chunks[0]);
        int chunkTwo = parseInt(chunks[1]);
        return List.of(chunkOne, chunkTwo);
    }
    @Override
    public int add(String numbers) {
        List<Integer> numberChunks = parse(numbers);
        AtomicInteger sum = new AtomicInteger();

        numberChunks.forEach(sum::addAndGet);

        return sum.get();
    }
}
