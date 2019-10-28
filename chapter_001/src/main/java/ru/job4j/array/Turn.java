package ru.job4j.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Turn {

    public int[] back(int[] array) {
        for (int i=0;i<array.length/2;i++) {
            int temp=array[i];
            int n=array.length-1-i;
            array[i]=array[n];
            array[n]=temp;
        }
        return array;
    }

    public static void main(String[] args) {
    }
}
