package ru.job4j;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        for (String s:deps) {
            tmp.add(s);
        }
        for (String value : deps) {
            String s1 = "";
            String s2 = "";
            for (String el : value.split("/")) {
                s1=s2+el;
                s2=s1+"/";
                tmp.add(s1);
            }
        }
        List<String>list=new ArrayList<>();
        for (String s:tmp) {
            list.add(s);
        }
        sortAsc(list);
        return list;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs, new Comparator<String>() {
            @Override
            public int compare(String n, String m){
                String[]a=n.split("/");
                String[]b=m.split("/");
                int p=0;
                Integer k=b.length;
                Integer s=a.length;
                if (b.length<a.length) s=b.length;
                for (int i=0;i<s;i++) {
                    if (a[i].compareTo(b[i])!=0){
                        p=a[i].compareTo(b[i]);
                        break;}
                }
                if (p==0) {
                    p=s.compareTo(k);
                }
                return p;
            }
        });

    }
    public static void sortDesc(List<String> orgs) {
        sortAsc(orgs);
        Collections.reverse(orgs);
    }

    public static void main(String[] args) {
        List<String>arr=new ArrayList<>();
        arr.add("K1/SK1/SSK2");
        arr.add("K2");
        arr.add("K1/SK1");
        arr.add("K1/SK2");
        arr.add("K1/SK1/SSK1");
        arr.add("K2/SK1/SSK1");
        List<String>arr1=fillGaps(arr);
        sortDesc(arr1);
        for (String s:arr1) {
            System.out.println(s);
        }

    }
}