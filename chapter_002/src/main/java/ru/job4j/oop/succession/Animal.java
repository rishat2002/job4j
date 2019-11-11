package ru.job4j.oop.succession;

public class Animal {
    public Animal() {
        System.out.println("Animal");
    }

    public static void main(String[] args) {
        Animal animal=new Animal();
        Predator predator=new Predator();
        Tiger tiger=new Tiger();
    }
}
class Predator extends Animal {
    public Predator() {
        super();
        System.out.println("Predator");
    }
}
class Tiger extends Predator {
    public Tiger() {
        super();
        System.out.println("Tiger");
    }
}