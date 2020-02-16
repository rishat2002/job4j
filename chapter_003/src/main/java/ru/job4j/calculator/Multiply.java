package ru.job4j.calculator;

public class Multiply implements Operations {
    private String operationName="Умножение";
    public String getOperationName() {
        return operationName;
    }
    @Override
    public double operation(double firstValue, double secondValue) {
        return  firstValue*secondValue;
    }

}
