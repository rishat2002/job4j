package ru.job4j.calculator;

import java.util.Scanner;

public class InteractCalc {
    private Calculate calc=new Calculate();
    public void mainMethod() {

        Double result=0.0;
        String personInput=" ";
        while (!personInput.equals("6")) {
            System.out.println(new StringBuilder().append("Выберите операцию:\n").append("1. Сложение\n").append("2. Вычитание\n").append("3. Умножение\n")
                    .append("4. Деление\n").append("5. Стереть результат\n").append("6. Закончить\n").toString());
            Scanner in=new Scanner(System.in);
            personInput=in.nextLine();
            switch (personInput) {
                case "1":
                    System.out.println("Введите данные");
                    if (result==0) {
                        result=in.nextDouble();
                    }
                    result = calc.plus(result, in.nextDouble());
                    System.out.println(result);
                    break;
                case "2":
                    System.out.println("Введите данные");
                    if (result==0) {
                        result=in.nextDouble();
                    }
                    result = calc.minus(result, in.nextDouble());
                    System.out.println(result);
                    break;
                case "3":
                    System.out.println("Введите данные");
                    if (result==0) {
                        result=in.nextDouble();
                    }
                    result = calc.multipluer(result, in.nextDouble());
                    System.out.println(result);
                    break;
                case "4":
                    System.out.println("Введите данные");
                    if (result==0) {
                        result=in.nextDouble();
                    }
                    result = calc.division(result, in.nextDouble());
                    System.out.println(result);
                    break;
                case "5":
                    result = 0.0;
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Неправильный ввод");
                    break;
            }
        }

    }

    public static void main(String[] args) {
        InteractCalc i=new InteractCalc();
        i.mainMethod();
    }
}
