package com.tests.calculactorWithwTests;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int subtract(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Деление на 0 недопустимо");
        }
        return num1 / num2;
    }
}
