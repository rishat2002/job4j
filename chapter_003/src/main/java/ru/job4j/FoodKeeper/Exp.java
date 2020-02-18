package ru.job4j.FoodKeeper;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Exp {
    public static void main(String[] args) {
       Calendar create=new GregorianCalendar(2012,02,3,14,10);
       Calendar expair=new GregorianCalendar(2012,02,5,14,10);
       Calendar nowDate=new GregorianCalendar(2012,02,4,14,10);
       long i1=nowDate.getTimeInMillis()-create.getTimeInMillis();
       long i2=expair.getTimeInMillis()-create.getTimeInMillis();
        System.out.println((double) i1/i2);
    }
}
