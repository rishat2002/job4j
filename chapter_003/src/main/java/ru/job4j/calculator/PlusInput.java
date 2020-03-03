package ru.job4j.calculator;

import java.util.Scanner;

public class PlusInput implements Input {
    private final String operationName="Плюс";
    @Override
    public String getOperationName() {
        return operationName;
    }
    @Override
    public double execute(Calculate calc, double result) {
        Scanner in=new Scanner(System.in);
        System.out.println("Введите данные");
        if (result==0) {
            result=in.nextDouble();
        }
        result = calc.plus(result, in.nextDouble());
        System.out.println(result);
        return result;
    }
}
