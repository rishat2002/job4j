package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int finish) {
        int n=0;
        for (int i=1;i<=finish;i++) {
            if (finish%i==0) {
                n++;
            }
        }
        boolean prime = true;
        if (n>2) {
        prime=false;
        }

        return prime;
    }
}
