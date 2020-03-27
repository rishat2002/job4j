package ru.job4j.FoodKeeper;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private List<Food> foods=new ArrayList<>();
    public List<Food> getFoods() {
        return foods;
    }
    public double procent(Food food) {
        long i1=food.getNowDate().getTimeInMillis()-food.getCreateDate().getTimeInMillis();
        long i2=food.getExpaireDate().getTimeInMillis()-food.getCreateDate().getTimeInMillis();
        double procent = ((double)i1/(double)i2);
        return procent;
    }
    @Override
    public boolean accept(Food food) {
        boolean n=false;
        if (this.procent(food)>0.75 && this.procent(food)<1.0) {
            food.setPrice(food.getPrice()*food.getDiscount());
            foods.add(food);
            return n=true;
        }
        else if (this.procent(food)>=0.25 && this.procent(food)<=0.75) {
           foods.add(food);
           return n=true;
        }
        return n;
    }
}