package ru.job4j.FoodKeeper;

import java.util.Calendar;

public class Bread extends Food {
    private String type;
    public Bread(String name, Calendar expaireDate, Calendar createDate, Calendar nowDate, double price, double discount,String type) {
        super(name, expaireDate, createDate, nowDate, price, discount);
        this.type=type;
    }
}
