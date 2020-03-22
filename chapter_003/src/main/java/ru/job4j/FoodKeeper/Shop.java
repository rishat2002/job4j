package ru.job4j.FoodKeeper;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Keeper {
    private List<Food> foods=new ArrayList<>();
    public List<Food> getFoods() {
        return foods;
    }
    @Override
    public void accept(Food food) {
        if (this.procent(food)>0.75 && this.procent(food)<1.0) {
            food.setPrice(food.getPrice()*food.getDiscount());
            this.getFoods().add(food);
        }
        else if (this.procent(food)>=0.25 && this.procent(food)<=0.75) {
            this.getFoods().add(food);
        }
    }
}
