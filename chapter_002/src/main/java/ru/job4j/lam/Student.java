package ru.job4j.lam;

import java.util.Set;

public class Student {
    private String name;
    private Set<String> units;

    public Student(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getUnits() {
        return units;
    }

    public void setUnits(Set<String> units) {
        this.units = units;
    }
}
