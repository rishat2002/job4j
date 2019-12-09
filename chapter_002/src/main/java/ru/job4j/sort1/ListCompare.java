package ru.job4j.sort1;
import java.util.Comparator;
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int n=0;
        char[] leftmass=left.toCharArray();
        char[] rightmass=right.toCharArray();
        int lenght=0;
        lenght=leftmass.length>=rightmass.length?rightmass.length:leftmass.length;
            for (int i=0;i<lenght;i++) {
                n=Character.compare(leftmass[i], rightmass[i]);
                if (n!=0) {
                    break;
                }
            }
        if (n<=0) {
            if (leftmass.length<rightmass.length) {
                n=-2;
            }
        }
        if (n>=0) {
            if (leftmass.length>rightmass.length) {
                n=2;
            }
        }
        return n;
        }


    public static void main(String[] args) {
        ListCompare list=new ListCompare();
        System.out.println(list.compare("123","12345"));
        System.out.println("123".compareTo("12345"));
    }
}