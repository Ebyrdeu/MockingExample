package com.example.g;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleCalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new SimpleCalculator();
    }

    @Test
    @DisplayName("Assure that empty string return 0")
    void assureThatEmptyStringReturn0() {
        int result = calculator.add("");
        assertThat(result).as("Return 0").isEqualTo(0);
    }
}