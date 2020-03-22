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
    public void distributer() {
        this.clearKeeep();
    for (Keeper p:k) {
       for (Food f:l) {
           p.accept(f);
       }
    }}
    public void clearKeeep() {
            for (Keeper p:k) {
                p.getFoods().clear();
            }
    }
    public void resort (List<Keeper>t) {
        List<Food>s=new ArrayList<>();
        for (Keeper m:k) {
        for (Food a:m.getFoods()) {
            s.add(a);
        }
        }
        new ControllQuality(t,s);
    }
    public static void main(String[] args) {
}
}
//3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
////3.2 Если срок годности от 25% до 75% направить в Shop
////3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
////3.4. Если срок годности вышел. Отправить продукт в мусорку.

//long i1=nowDate.getTimeInMillis()-create.getTimeInMillis();
//       long i2=expair.getTimeInMillis()-create.getTimeInMillis();
//        System.out.println((double) i1/i2);