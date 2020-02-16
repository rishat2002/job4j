package ru.job4j.calculator;

public class Division implements Operations {
    private String operationName="Деление";
    public String getOperationName() {
        return operationName;
    }
    @Override
    public double operation(double firstValue, double secondValue) {
        return firstValue/secondValue;
    }
}
