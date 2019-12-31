package ru.job4j.LearnList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrList<E> implements Iterable<E> {
    private Object[]mass;
    private int index=0;
    private int modCount=0;
    public ArrList() {
        this.mass = new Object[10];
    }
    public void add(E value){
    modCount++;
    if (index<mass.length) {
        mass[index]=value;
        index++;
    }
    else {
    Object[] biggermass=new Object[mass.length*2];
    System.arraycopy(mass,0,biggermass,0,mass.length);
    mass=biggermass;
    mass[index++]=value;
    }}

    public E get(int i){
    return (E) mass[i];
    }

    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            private int s=modCount;
            private int i=0;
            @Override
            public boolean hasNext() {
                if (i<=index) return true;
                else return false;
            }
            @Override
            public E next() throws NoSuchElementException,ConcurrentModificationException{
                if (s!=modCount) throw  new ConcurrentModificationException();
                if (i>index) throw new NoSuchElementException();
                return (E) mass[i++];
            }
        };
    }
}
