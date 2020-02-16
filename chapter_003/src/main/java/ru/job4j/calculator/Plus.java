package ru.job4j.calculator;

public class Plus implements Operations {
    private String operationName="Плюс";
    public String getOperationName() {
        return operationName;
    }
    @Override
    public double operation(double firstValue, double secondValue) {
        return firstValue+secondValue;
    }
}
