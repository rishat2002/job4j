package ru.job4j.LearnList;

public class SimpleSet<T> extends ArrList<T>  {

    ArrList<T>arr=new ArrList<T>();
    public void add(T value) {
        boolean n=true;
    for (int i=0;i<arr.getIndex();i++) {
        if(value.equals(arr.get(i))) {
            n=false;
            break;
        }
    }
    if (n==true) {
        arr.add(value);
    }
    }
}
