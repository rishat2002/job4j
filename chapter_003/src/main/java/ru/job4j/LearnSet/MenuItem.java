package ru.job4j.LearnSet;

import java.util.ArrayList;
import java.util.List;

public class MenuItem<String extends Comparable<String>> {
    private final List<MenuItem<String>> children = new ArrayList<>();
    private String name;
    private String point;
    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
    public String getName() {
        return name;
    }
    public MenuItem(final String value) {
        this.name = value;
    }
    public void add(MenuItem<String> child) {
        child.point= (String) Integer.valueOf(this.leaves().size()+1);
        child.name= (String) (child.point+"."+this.name);
        this.children.add(child);
    }
    public List<MenuItem<String>> leaves() {
        return this.children;
    }
    public boolean eqValue(String that) {
        return this.name.compareTo(that) == 0;

    }
}
