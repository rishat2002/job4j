package ru.job4j.FoodKeeper;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private List<Keeper>k=new ArrayList<>();
    private List<Food>l=new ArrayList<>();
    public ControllQuality(List<Keeper> k,List<Food>l) {
        this.k = k;
        this.l = l;
    }

    public List<Keeper> getK() {
        return k;
    }

    public List<Food> getL() {
        return l;
    }

    private void setK(List<Keeper> k) {
        this.k = k;
    }

    public void distributer() {
        this.clearKeeep();
    for (Keeper p:k) {
       for (Food f:l) {
           if (p.accept(f)) {
            l.remove(f);
           }
       }
    }}
    public void clearKeeep() {
            for (Keeper p:k) {
                p.getFoods().clear();
            }
    }
    public void resort (List<Keeper>t) {
     this.setK(t);
     this.distributer();
    }

    public static void main(String[] args) {
        List<Keeper>k=List.of(new Trash(),new WareHouse(),new Shop());
     }
}
//3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
////3.2 Если срок годности от 25% до 75% направить в Shop
////3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
////3.4. Если срок годности вышел. Отправить продукт в мусорку.

//long i1=nowDate.getTimeInMillis()-create.getTimeInMillis();
//       long i2=expair.getTimeInMillis()-create.getTimeInMillis();
//        System.out.println((double) i1/i2);