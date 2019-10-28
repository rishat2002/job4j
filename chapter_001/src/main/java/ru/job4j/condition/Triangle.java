package ru.job4j.condition;

public class Triangle {

    public static boolean exist(double ab, double ac, double bc) {
        boolean triangle=false;
        if (ab + ac > bc && ac + bc > ab && ab + bc > ac) {
            triangle=true;
        }
        return triangle;
    }

}
