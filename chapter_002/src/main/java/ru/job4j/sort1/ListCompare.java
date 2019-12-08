package ru.job4j.sort1;
import java.util.Comparator;
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int n=0;
        char[] leftmass=left.toCharArray();
        char[] rightmass=right.toCharArray();
        if (leftmass.length>=rightmass.length) {
            for (int i=0;i<rightmass.length;i++) {
                n=Character.compare(leftmass[i], rightmass[i]);
                if (n!=0) {
                    break;
                }
            }
        }
        else {
            for (int i=0;i<leftmass.length;i++) {
                n=Character.compare(leftmass[i], rightmass[i]);
                if (n!=0) {
                    break;
                }
            }
        }
        if (n==0) {
            if (leftmass.length>rightmass.length) {
                n=1;
            }
            if (leftmass.length<rightmass.length) {
                n=-1;
            }
        }
        return n;
        }


    public static void main(String[] args) {
    }
}