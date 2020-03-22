package ru.job4j.LearnSet;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E>,AddMenu<E>,ShowMenu<E> {
    private E rootvalue;
    private MenuItem<E> root;
    private int modCount = 0;

    public Tree(E rootvalue) {
        this.root = new MenuItem<>(rootvalue);
    }

    @Override
    public boolean add(E parent) {
        boolean n = true;
        var s=this.findBy(parent);
        MenuItem<E> newnod = new MenuItem<>(parent);
        s.get().add((newnod));
        modCount++;
        return n;
    }

    @Override
    public Optional<MenuItem<E>> findBy(E value) {
        Optional<MenuItem<E>> rsl = Optional.empty();
        Queue<MenuItem<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            MenuItem<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (MenuItem<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<MenuItem<E>> data = new LinkedList<>();
        data.offer(this.root);
        return new Iterator<E>() {
            private int n=modCount;
            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            @Override
            public E next() {
                E value=null;
                if (n != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                MenuItem<E> el = data.poll();
                for (MenuItem<E> child : el.leaves()) {
                        data.offer(child);
                }
                value=el.getName();
                return value;
            }
        };
    }
    @Override
    public void showmenu() {
        Iterator<E>iter=this.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}

