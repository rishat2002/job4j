package ru.job4j.LearnList;

public class SimpleQueu<T> extends SimpleStack<T> {

    public void push(T value){
        this.getList().addInEnd(value);
    }

}
