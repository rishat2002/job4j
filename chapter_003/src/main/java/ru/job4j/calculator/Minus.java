package ru.job4j.calculator;

public class Minus implements Operations{
    private String operationName="Минус";
    public String getOperationName() {
        return operationName;
    }
    @Override
    public double operation(double firstValue, double secondValue) {
        return firstValue-secondValue;
    }
}
