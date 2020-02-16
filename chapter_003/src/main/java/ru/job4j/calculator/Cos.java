package ru.job4j.calculator;

public class Cos implements Operations {
    private String operName="Вычисление косинуса";
    @Override
    public double operation(double firstValue, double secondValue) {
        return Math.cos(firstValue);
    }
    @Override
    public String getOperationName() {
        return operName;
    }
}
