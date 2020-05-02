package ru.job4j.FoodKeeper;

import java.util.ArrayList;
import java.util.List;

public interface Keeper {
    public List<Food> getFoods();
    public default double procent(Food food) {
        long i1=food.getNowDate().getTimeInMillis()-food.getCreateDate().getTimeInMillis();
        long i2=food.getExpaireDate().getTimeInMillis()-food.getCreateDate().getTimeInMillis();
        double procent = ((double)i1/(double)i2);
        return procent;
    }
    public boolean accept(Food food);
}
