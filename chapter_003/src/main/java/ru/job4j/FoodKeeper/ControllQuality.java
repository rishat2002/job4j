package ru.job4j.FoodKeeper;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private List<Keeper> keeper = new ArrayList<>();
    private List<Food> foodList = new ArrayList<>();

    public ControllQuality(List<Keeper> keeper, List<Food> foodList) {
        this.keeper = keeper;
        this.foodList = foodList;
    }

    private void setKeeper(List<Keeper> keeper) {
        this.keeper = keeper;
    }

    public void distributer() {
        this.clearKeeep();
        for (Keeper p : keeper) {
            for (Food f : foodList) {
                if (p.accept(f)) {
                    foodList.remove(f);
                }
            }
        }
    }

    public void clearKeeep() {
        for (Keeper p : keeper) {
            p.getFoods().clear();
        }
    }

    public void resort(List<Keeper> t) {
        this.setKeeper(t);
        this.distributer();
    }

    public static void main(String[] args) {
        List<Keeper> k = List.of(new Trash(), new WareHouse(), new Shop());
    }
}
//3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
////3.2 Если срок годности от 25% до 75% направить в Shop
////3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
////3.4. Если срок годности вышел. Отправить продукт в мусорку.

//long i1=nowDate.getTimeInMillis()-create.getTimeInMillis();
//       long i2=expair.getTimeInMillis()-create.getTimeInMillis();
//        System.out.println((double) i1/i2);