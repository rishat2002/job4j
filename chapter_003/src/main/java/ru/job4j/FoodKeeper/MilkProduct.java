package ru.job4j.FoodKeeper;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MilkProduct extends Food {
    private double fatness;

    public MilkProduct(String name, Calendar expair, Calendar create, Calendar now, int i, double v, Double fat) {
        super(name, expair, create, now, i, v);
        fatness=fat;
    }
}
