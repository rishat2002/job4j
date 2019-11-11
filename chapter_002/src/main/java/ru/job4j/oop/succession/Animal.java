package ru.job4j.oop.succession;

public class Animal {
    public Animal(String name) {
    }

    public static void main(String[] args) {
    }
}
class Predator extends Animal {
    public Predator(String name) {
        super(name);
    }
}
class Tiger extends Predator {
    public Tiger(String name) {
        super(name);
    }
}