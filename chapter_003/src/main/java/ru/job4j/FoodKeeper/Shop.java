package ru.job4j.FoodKeeper;

import java.util.ArrayList;
import java.util.List;

public class Shop extends Keeper {
    private List<Food> foods=new ArrayList<>();
    public List<Food> getFoods() {
        return foods;
    }
}
