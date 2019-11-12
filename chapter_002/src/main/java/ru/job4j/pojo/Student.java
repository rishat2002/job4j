package ru.job4j.pojo;
import java.util.Date;
public class Student {
private String name;
private String surname;
private int group;
private Date beginstudy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Date getBeginstudy() {
        return beginstudy;
    }

    public void setBeginstudy(Date beginstudy) {
        this.beginstudy = beginstudy;
    }
}
