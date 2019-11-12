package ru.job4j.condition;
public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }
    public double period(double a, double b, double c) {
    return (a + b + c) / 2;
    }
    private boolean exist(Triangle triangle) {
        return false;
    }
    public double area() {
        double rsl = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            rsl=Math.sqrt(p *(p - a) * (p - c) * (p - b));
        }
        return rsl;
    }
    private boolean exist(double a, double c, double b) {
        boolean triangle=false;
        if (a + c > b && a + c > b && b + c > a) {
            triangle=true;
        }
        return triangle;
    }

}