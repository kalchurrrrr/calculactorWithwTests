package com.tests.calculactorWithwTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTests {

    private CalculatorService calculatorService;

    @BeforeEach
    public void setup() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void testAdd() {
        int result = calculatorService.add(5, 5);
        Assertions.assertEquals(10, result);
    }

    @Test
    public void testSubtract() {
        int result = calculatorService.subtract(5, 5);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void testMultiply() {
        int result = calculatorService.multiply(5, 5);
        Assertions.assertEquals(25, result);
    }

    @Test
    public void testDivide() {
        int result = calculatorService.divide(5, 5);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void testDivideByZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(5, 0));
    }
}
