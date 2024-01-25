package com.example.g;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Parser {

    public static List<Integer> parse(String numbers) {
        if (numbers.isEmpty()) return List.of(0);
        if (numbers.length() == 1) return List.of(parseInt(numbers));
        String delimiter = "[\n,]";

        if (numbers.startsWith("//")) {
            int index = numbers.indexOf("\n");
            if (index != -1) {
                delimiter = Pattern.quote(numbers.substring(2, index));
                numbers = numbers.substring(index + 1);
            }
        }

        String[] chunks = numbers.split(delimiter);
        List<Integer> integerChunks = new ArrayList<>();

        for (String chunk : chunks) {
            int value = parseInt(chunk);
            if (value < 0) throw  new RuntimeException("negatives not allowed");
            if (value > 1000) value  = 0;
            integerChunks.add(value);
        }

        return integerChunks;
    }
}
