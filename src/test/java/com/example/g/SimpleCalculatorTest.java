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

    @Test
    @DisplayName("Assure that on string 1 return be 1 as int")
    void assureThatOnString1ReturnBe1AsInt() {
        int result = calculator.add("1");
        assertThat(result).as("Return 1").isEqualTo(1);
    }

    @Test
    @DisplayName("Assure thant on string 1,2 return be sum of 1 and 2")
    void assureThantOnString12ReturnBeSumOf1And2() {
        int result = calculator.add("1,2");
        assertThat(result).as("Return 3").isEqualTo(3);
    }

   @Test
   @DisplayName("Assure that method can handle an unknown amount of numbers")
   void assureThatMethodCanHandleAnUnknownAmountOfNumbers() {
    int result = calculator.add("1,2,3,4,5");
    assertThat(result).as("Return 15").isEqualTo(15);
   }
}