package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int countmatch=11;
        int n=0;
        Scanner input=new Scanner(System.in);
        while (countmatch>0) {
            if (n%2==0) {
                System.out.println("Ходит первый игрок");
            }
            else {
                System.out.println("Ходит второй игрок");
            }
            int select = Integer.valueOf(input.nextLine());
            countmatch=countmatch-select;
            System.out.println("Осталось "+countmatch+" спичек");
            n++;
        }
        if (!(n%2==0)) {
            System.out.println("Победил первый игрок");
        }
        else {
            System.out.println("Победил второй игрок");
        }
    }
}
