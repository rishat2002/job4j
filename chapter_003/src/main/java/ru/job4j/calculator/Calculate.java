package ru.job4j.calculator;

public class Calculate {
    public double plus(double firstValue,double secondValue) {
        return firstValue+secondValue;
    }
    public double minus(double firstValue,double secondValue) {
        return firstValue-secondValue;
    }
    public double multipluer(double firstValue,double secondValue) {
        return firstValue*secondValue;
    }
    public double cos(double first) {
        return Math.cos(first);
    }
    public double sin(double first) {
        return Math.sin(first);
    }
    public double tg(double first) {
        return Math.tan(first);
    }
}
