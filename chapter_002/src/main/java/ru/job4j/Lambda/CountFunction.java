package ru.job4j.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CountFunction {
    public List<Double> diapason(int start, int end, Function<Double, Double> func){
        List<Double>newList=new ArrayList<>();
        for (int index = start; index != end; index++) {
            newList.add(func.apply((double) index));
        }
        return newList;
    }

    public static void main(String[] args) {
      CountFunction func1=new CountFunction();
        List<Double>arr=new ArrayList<>();
        arr=func1.diapason(4,8,(index)->{
            return index*2+6;
        });
        for (Double del:arr) {
            System.out.println(del);
        }
    }
}
