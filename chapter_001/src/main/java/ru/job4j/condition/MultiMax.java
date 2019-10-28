package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
     int max=first;
     if (second>=first && second>=third) {
         max=second;
     }
     else if (third>=second && third>=first) {
         max=third;
     }
     return max;
    }

}
