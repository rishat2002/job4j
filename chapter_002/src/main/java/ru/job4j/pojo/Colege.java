package ru.job4j.pojo;

import java.util.Date;

public class Colege {
    public static void main(String[] args) {
        Student firststudent=new Student();
        firststudent.setSurname("Vasilev");
        firststudent.setName("Roma");
        firststudent.setGroup(1124);
        firststudent.setBeginstudy(new Date());
        System.out.println("Student "+firststudent.getSurname()+" "+firststudent.getName()+" group "+firststudent.getGroup()+" begin study "+firststudent.getBeginstudy());
    }
}
