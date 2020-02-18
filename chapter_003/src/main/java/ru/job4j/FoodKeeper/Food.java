package ru.job4j.FoodKeeper;

import java.util.Calendar;
import java.util.Date;

public class Food {
  private String name;
  private Calendar expaireDate;
  private Calendar createDate;
  private Calendar nowDate;
  private double price;
  private double discount;

  public Food(String name, Calendar expaireDate, Calendar createDate, Calendar nowDate, double price, double discount) {
    this.name = name;
    this.expaireDate = expaireDate;
    this.createDate = createDate;
    this.nowDate = nowDate;
    this.price = price;
    this.discount = discount;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Calendar getExpaireDate() {
    return expaireDate;
  }

  public void setExpaireDate(Calendar expaireDate) {
    this.expaireDate = expaireDate;
  }

  public Calendar getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Calendar createDate) {
    this.createDate = createDate;
  }

  public Calendar getNowDate() {
    return nowDate;
  }

  public void setNowDate(Calendar nowDate) {
    this.nowDate = nowDate;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }
}
//Часть 1.
//Создать класс Food сполями. Name, expaireDate, createDate, price, disscount. На основе класса Food создать другие продукты.
//Создать классы хранилище продуктов Warehouse, Shop, Trash.
//Создать класс обработчик перераспределения продуктов в место использования. ControllQuality. Класс должен перераспределять еду по хранилищам в зависимости от условиый.
//3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
//3.2 Если срок годности от 25% до 75% направить в Shop
//3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
//3.4. Если срок годности вышел. Отправить продукт в мусорку.
//В данной задаче надо использовать шаблон проектирование - https://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
//Нельзя использовать instanceOf или if ("Shop".equals(storage.getName())