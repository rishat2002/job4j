package ru.job4j.calculator;

public class Sin implements Operations {
    private String operName="Вычисление синуса";
    @Override
    public double operation(double firstValue, double secondValue) {
        return Math.sin(firstValue);
    }

    @Override
    public String getOperationName() {
        return operName;
    }
}
