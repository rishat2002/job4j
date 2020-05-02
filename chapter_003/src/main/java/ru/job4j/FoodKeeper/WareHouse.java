package ru.job4j.FoodKeeper;

import java.util.ArrayList;
import java.util.List;

public class WareHouse implements Keeper {
    private List<Food> foods=new ArrayList<>();
    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public boolean accept(Food food) {
        boolean n=false;
        if (this.procent(food)<0.25) {
            foods.add(food);
            return true;
        }
        return n;
    }
}
