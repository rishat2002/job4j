package ru.job4j.FoodKeeper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ControllQuality {
    private List<Store> k=new ArrayList<>();
    public double procent(Food food) {
        long i1=food.getNowDate().getTimeInMillis()-food.getCreateDate().getTimeInMillis();
        long i2=food.getExpaireDate().getTimeInMillis()-food.getCreateDate().getTimeInMillis();
        double procent = ((double)i1/(double)i2);
        return procent;
    }
    public ControllQuality(List<Store> k) {
        this.k = k;
    }
    public void distributer(Food food) {
   for (Store s:k) {
       s.accept(food);
    }
    }

    public static void main(String[] args) {
        List<Store> k=new ArrayList<>();
        k.add(new Shop());
        k.add(new Trash());
        k.add(new WareHouse());
    ControllQuality c1=new ControllQuality(k);
    Calendar expairDate=new GregorianCalendar(2012,3,5,14,5);
    Calendar createDate=new GregorianCalendar(2012,2,5,16,5);
    Calendar nowDate=new GregorianCalendar(2012,2,10,13,6);
    Food pom=new Food("pomidor",expairDate,createDate,nowDate,150,0.75);
    Calendar expairDate1=new GregorianCalendar(2012,4,5,16,5);
    Calendar createDate1=new GregorianCalendar(2012,3,10,16,10);
    Calendar nowDate1=new GregorianCalendar(2012,4,1,20,5);
    MilkProduct milk1=new MilkProduct("молочник",expairDate1,createDate1,nowDate1,150,0.75,1.5);
    Calendar expairDate2=new GregorianCalendar(2012,4,5,17,6);
    Calendar createDate2=new GregorianCalendar(2012,3,10,17,6);
    Calendar nowDate2=new GregorianCalendar(2012,4,8,20,0);
    Bread bread=new Bread("черный хлеб",expairDate2,createDate2,nowDate2,150,0.75,"круглый");
    c1.distributer(pom);
    c1.distributer(milk1);
    c1.distributer(bread);

}
}
//3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
////3.2 Если срок годности от 25% до 75% направить в Shop
////3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
////3.4. Если срок годности вышел. Отправить продукт в мусорку.

//long i1=nowDate.getTimeInMillis()-create.getTimeInMillis();
//       long i2=expair.getTimeInMillis()-create.getTimeInMillis();
//        System.out.println((double) i1/i2);