package ru.job4j;

import java.util.*;

public class Exp {
    Map<Integer,String> map=new TreeMap<>();
    public Map<Integer, String> sortString(String n) {
        String l=null;
        l=n.substring(n.indexOf("K")+1,n.indexOf("K")+2);
        if (n.indexOf("SK")==-1) {
            l=l+"0";
        }
        else {
            l=l+n.substring(n.indexOf("SK")+2,n.indexOf("SK")+3);
        }
        if (n.indexOf("SSK")==-1) {
            l=l+"0";
        }
        else {
            l=l+n.substring(n.indexOf("SSK")+3,n.indexOf("SSK")+4);
        }
        map.putIfAbsent(Integer.parseInt(l),n);
       return map;
    }
    public String[] sortMass(String[] s) {
        String [] sortmass=new String[s.length];
        for (String l:s) {
            this.sortString(l);
        }
        int i=0;
        for (Map.Entry<Integer,String> k:map.entrySet()) {
            sortmass[i]=k.getValue();
            System.out.println(sortmass[i]);
        }
        return sortmass;
    }
    public static void main(String[] args) {
    }
}