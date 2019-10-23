package ru.job4j.converter;

public class Converter {
    public static int rubleToEuro(int value) { return value / 70; }
    public static int rubleToDollar(int value) {
        return value /60;
    }
    public static int euroToRuble(int value) {
        return value *70;
    }
    public static int dollarToRuble(int value) {
        return value *60;
    }
    public static void main(String[] args) {
        int in=210;
        int expected=3;
        boolean passed=expected==rubleToEuro(in);
        System.out.println("210 rubles are 3. Test result : " + passed);
        int in1=180;
        int expected1=3;
        boolean passed1=expected1==rubleToDollar(in1);
        System.out.println("180 rubles are 3. Test result : " + passed1);
        int in2=4;
        int expected2=240;
        boolean passed2=expected2==dollarToRuble(in2);
        System.out.println("4 dollars are 240. Test result : " + passed2);
        int in3=4;
        int expected3=280;
        boolean passed3=expected3==euroToRuble(in3);
        System.out.println("4 euro are 280. Test result : " + passed3);
    }
}
