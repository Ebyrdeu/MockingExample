package com.example.g;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleCalculator implements Calculator {
    @Override
    public int add(String numbers) {
        List<Integer> numberChunks = Parser.parse(numbers);
        AtomicInteger sum = new AtomicInteger();

        numberChunks.forEach(sum::addAndGet);

        return sum.get();
    }
}


