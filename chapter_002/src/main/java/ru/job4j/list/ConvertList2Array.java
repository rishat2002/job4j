package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size()/rows);
        System.out.println(cells);
        int[][] array = new int[rows][(int)cells];
        int listnum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (listnum>=list.size()) {
                    break;
                }
                array[i][j] = list.get(listnum);
                listnum++;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> list2 = new ArrayList<Integer>();
        for (int[] n : list) {
            for (Integer n1 : n) {
                list2.add(n1);
            }
        }
        return list2;
    }

    public static void main(String[] args) {
        ConvertList2Array list = new ConvertList2Array();
        List<Integer>list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        int[][] result = list.toArray(list1,3);
    }
}
