package ru.job4j.sort1;
import java.util.Comparator;
public class User implements Comparable<User> {
 private int age;
 private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(User o) {
        return age-o.getAge();
    }

    @Override
    public boolean equals(Object obj) {
        User o=(User)obj;
        return this.getAge()==o.getAge() && this.getName().equals(o.getName());
    }
}
