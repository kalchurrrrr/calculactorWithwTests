package com.tests.calculactorWithwTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 10})
    public void testAddMultipleValues(int num) {
        int result = calculatorService.add(num, num);
        Assertions.assertEquals(2 * num, result);
    }

    @ParameterizedTest
    @MethodSource("com.tests.calculactorWithwTests.CalculatorServiceTests#subtractArguments")
    public void testSubtractMultipleValues(int num1, int num2) {
        int result = calculatorService.subtract(num1, num2);
        Assertions.assertEquals(num1 - num2, result);
    }

    static Stream<Arguments> subtractArguments() {
        return Stream.of(
                Arguments.of(10, 5),
                Arguments.of(8, 3),
                Arguments.of(20, 10)
        );
    }

    @ParameterizedTest
    @CsvSource({"2, 3, 6", "5, 5, 25", "10, 4, 40"})
    public void testMultiplyMultipleValues(int num1, int num2, int expected) {
        int result = calculatorService.multiply(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"4, 2, 2", "10, 2, 5", "20, 10, 2"})
    public void testDivideMultipleValues(int num1, int num2, int expected) {
        int result = calculatorService.divide(num1, num2);
        Assertions.assertEquals(expected, result);
    }
}
