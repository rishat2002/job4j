package ru.job4j.calculator;

public class Tang implements Operations {
    private String operName="Вычисление тангенса";
    @Override
    public double operation(double firstValue, double secondValue) {
        return Math.tan(firstValue);
    }

    @Override
    public String getOperationName() {
        return operName;
    }
}
