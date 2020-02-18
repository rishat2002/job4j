package ru.job4j.FoodKeeper;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControllQuality {
    private Trash trash=new Trash();
    private WareHouse ware= new WareHouse();
    private Shop shop=new Shop();

    public Trash getTrash() {
        return trash;
    }

    public WareHouse getWare() {
        return ware;
    }

    public Shop getShop() {
        return shop;
    }

    public double procent(Food food) {
        long i1=food.getNowDate().getTimeInMillis()-food.getCreateDate().getTimeInMillis();
        long i2=food.getExpaireDate().getTimeInMillis()-food.getCreateDate().getTimeInMillis();
        double procent = ((double)i1/(double)i2);
        return procent;
    }
    public void distributer(Food food) {
    if (this.procent(food)>0.75 && this.procent(food)<1.0) {
        food.setPrice(food.getPrice()*food.getDiscount());
            shop.getFoods().add(food);
    }
    else if (this.procent(food)>=0.25 && this.procent(food)<=0.75) {
            shop.getFoods().add(food);
    }
    else if (this.procent(food)<0.25) {
        ware.getFoods().add(food);
    }
    else {
        trash.getFoods().add(food);
        }
    }

    public static void main(String[] args) {
    ControllQuality c1=new ControllQuality();
    Calendar expairDate=new GregorianCalendar(2012,3,5,14,5);
    Calendar createDate=new GregorianCalendar(2012,2,5,16,5);
    Calendar nowDate=new GregorianCalendar(2012,2,10,13,6);
    Food pom=new Food("pomidor",expairDate,createDate,nowDate,150,0.75);
    System.out.println(c1.procent(pom));
    Calendar expairDate1=new GregorianCalendar(2012,4,5,16,5);
    Calendar createDate1=new GregorianCalendar(2012,3,10,16,10);
    Calendar nowDate1=new GregorianCalendar(2012,4,1,20,5);
    MilkProduct milk1=new MilkProduct("молочник",expairDate1,createDate1,nowDate1,150,0.75,1.5);
    System.out.println(c1.procent(milk1));
    Calendar expairDate2=new GregorianCalendar(2012,4,5,17,6);
    Calendar createDate2=new GregorianCalendar(2012,3,10,17,6);
    Calendar nowDate2=new GregorianCalendar(2012,4,8,20,0);
    Bread bread=new Bread("черный хлеб",expairDate2,createDate2,nowDate2,150,0.75,"круглый");
    System.out.println(c1.procent(bread));
    c1.distributer(pom);
    c1.distributer(milk1);
    c1.distributer(bread);
        System.out.println("shop");
    for (Food f:c1.getShop().getFoods()) {
        System.out.println(f.getName());
    }
        System.out.println("trash");
    for (Food f:c1.getTrash().getFoods()) {
            System.out.println(f.getName());
    }
        System.out.println("ware");
    for (Food f:c1.getWare().getFoods()) {
            System.out.println(f.getName());
    }
}
}
//3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
////3.2 Если срок годности от 25% до 75% направить в Shop
////3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
////3.4. Если срок годности вышел. Отправить продукт в мусорку.

//long i1=nowDate.getTimeInMillis()-create.getTimeInMillis();
//       long i2=expair.getTimeInMillis()-create.getTimeInMillis();
//        System.out.println((double) i1/i2);