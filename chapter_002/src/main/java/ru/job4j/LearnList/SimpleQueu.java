package ru.job4j.LearnList;

public class SimpleQueu<T> {
    private SimpleArrayList<T>list=new SimpleArrayList<T>();
    public T poll() {
        T result=list.get(0);
        list.delete();
        return result;
    }

    public void push(T value){
        list.addInEnd(value);
    }
    public T get(int i) {
        return list.get(i);
    }
}
