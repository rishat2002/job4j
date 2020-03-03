package ru.job4j.calculator;

import java.util.Scanner;

public class CosInput implements Input {
    private final String operationName="Вычисление косинуса";
    @Override
    public String getOperationName() {
        return operationName;
    }
    @Override
    public double execute(Calculate calc, double result) {
        Scanner in=new Scanner(System.in);

        if (result==0) {
            System.out.println("Введите данные");
            result=in.nextDouble();
        }
        result = calc.cos(result);
        System.out.println(result);
        return result;
    }
}
