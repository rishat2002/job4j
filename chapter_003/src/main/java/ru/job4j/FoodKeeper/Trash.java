package ru.job4j.FoodKeeper;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Keeper {
    private List<Food> foods=new ArrayList<>();
    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public boolean accept(Food food) {
        boolean n=false;
         if (this.procent(food)<1.0) {
             this.getFoods().add(food);
             return true;
        }
         return n;
    }
}
