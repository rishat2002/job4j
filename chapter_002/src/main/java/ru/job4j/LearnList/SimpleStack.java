package ru.job4j.LearnList;

public class SimpleStack<T> {
    private SimpleArrayList<T> list = new SimpleArrayList<T>();

    public SimpleArrayList<T> getList() {
        return list;
    }

    public T poll() {
        T result = list.get(0);
        list.delete();
        return result;
    }

    public void push(T value) {
        list.add(value);
    }

}
