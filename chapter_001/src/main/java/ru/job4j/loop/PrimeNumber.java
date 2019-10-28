package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;

        for (int i=2;i<=finish;i++) {
            int n=0;
            for (int j=2;j<i;j++) {
                if(i%j==0){
                    n++;
                }
            }
            if (n>0) {
                count--;
            }
                count++;
        }
        return count;
    }
}
