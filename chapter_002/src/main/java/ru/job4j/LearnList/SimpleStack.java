package ru.job4j.LearnList;

public class SimpleStack<T> {
    private SimpleArrayList<T>list=new SimpleArrayList<T>();
    public T poll() {
    T result=list.get(0);
    list.delete();
    return result;
    }

    public void push(T value){
    list.add(value);
    }
    public T get(int i) {
        return list.get(i);
    }
}
