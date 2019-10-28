package ru.job4j.calculator;
/**
 * Package for calculate task.
 *
 * @author Rishat
 * @version $Id$
 * @since 0.1
 */

public class Calculate {
    /**finding amount
     * @param first
     * @param second
     */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + "+" + second + " = " + result);
    }

    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        add(1, 1);
    }
}
