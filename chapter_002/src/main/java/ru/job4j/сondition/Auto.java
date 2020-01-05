package ru.job4j.сondition;

import java.util.Objects;

public class Auto {

    private String model;
    private int manufactureYear;
    private int dollarPrice;

    public Auto(String model, int manufactureYear, int dollarPrice) {
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.dollarPrice = dollarPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return manufactureYear == auto.manufactureYear &&
                dollarPrice == auto.dollarPrice &&
                Objects.equals(model, auto.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, manufactureYear, dollarPrice);
    }
}