package ru.job4j.ru.job4j.calculator.Sort;
import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int k=0;
        int m=0;
        for (int i=0;i<rsl.length;i++) {
            if (left[left.length-1]>right[right.length-1]) {
            if ( m<right.length && left[k]>right[m]) {
                rsl[i]=right[m];
                m++;
            }
            else {
                rsl[i]=left[k];
                k++;
            }}
            if (left[left.length-1]<right[right.length-1]) {
                if ( k<left.length && left[k]<right[m]) {
                    rsl[i]=left[k];
                    k++;
                }
                else {
                    rsl[i]=right[m];
                    m++;
                }}

        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3,5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
        int[] rsl1 = process.merge(
                new int[] {1, 3},
                new int[] {2, 4,5}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
