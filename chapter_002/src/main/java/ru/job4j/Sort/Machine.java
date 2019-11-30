package ru.job4j.Sort;
import java.util.Arrays;

public class Machine {
    private final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int difference=money-price;
         for (int i=0;i<4;i++) {
          while (difference-COINS[i]>=0){
              difference=difference-COINS[i];
              System.out.println(COINS[i]);
              rsl[size]=COINS[i];
              size++;
          }
          }

        return Arrays.copyOf(rsl, size);
    }

    public static void main(String[] args) {

    }
}