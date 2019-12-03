package ru.job4j.list;
import java.util.ArrayList;
import java.util.List;
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells =list.size()/rows;
        if (!(list.size()%rows==0)) {
            cells=list.size()/rows+1;
        }
        if (!(cells*rows==list.size())) {
            for (int i=list.size();i<cells*rows;i++) {
                list.add(0);
            }
        }
        int[][] array = new int[rows][cells];
        int listnum=0;
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cells;j++) {
                array[i][j]=list.get(listnum);
                listnum++;
            }
        }
        return array;
    }
}