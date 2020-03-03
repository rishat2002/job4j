package ru.job4j.calculator;

import java.util.Scanner;

public class MinusInput implements Input {
    private final String operationName="Минус";
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
        result = calc.minus(result, in.nextDouble());
        System.out.println(result);
        return result;
    }
}
