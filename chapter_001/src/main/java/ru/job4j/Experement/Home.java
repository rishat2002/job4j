package ru.job4j.Experement;

public class Home {
    public Home(String name) {
        this.name = name;
    }

    String name;

    public static void main(String[] args) {
        Home home=new Home("Vanya");
        System.out.println(home.name);
        home=null;
        System.out.println(home.name);
    }
}
