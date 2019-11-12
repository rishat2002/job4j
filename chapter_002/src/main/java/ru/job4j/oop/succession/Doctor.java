package ru.job4j.oop.succession;

class Doctor extends Profession {
    public Diagnose heal(Pacient pacient) {
        return new Diagnose();
    }
    private int successoperation;
    private int unsuccessoperation;
}