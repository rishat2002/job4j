package ru.job4j.FoodKeeper;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Keeper {
    private List<Food> foods=new ArrayList<>();
    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public void accept(Food food) {
         if (this.procent(food)<1.0) {
             this.getFoods().add(food);
        }
    }
}
