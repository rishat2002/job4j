package ru.job4j.lam;

import java.util.*;
import java.util.stream.Collectors;

public class Group {
    public static Map<String, Set<String>> sections(List<Student> students) {
     Map<String,Set<String>>map=students.stream()
             .flatMap(student -> student.getUnits().stream().map(n->new Holder(student.getName(),n)))
             .collect(Collectors.groupingBy(Holder::getSect,Collectors.mapping(Holder::getStud,Collectors.toSet())));
        return map;}

    public static void main(String[] args) {
        Set<String>newsect= new HashSet<String>();
        newsect.add("von");
        newsect.add("vod");
        newsect.add("vol");
        Set<String>newsect1= new HashSet<String>();
        newsect1.add("vod");
        newsect1.add("vol");
        Set<String>newsect2= new HashSet<String>();
        newsect2.add("von");
        newsect2.add("vol");
        List<Student>students= Arrays.asList(
                new Student("vasya",newsect),
                new Student("sema",newsect1));
        System.out.println(Group.sections(students));
    }
}