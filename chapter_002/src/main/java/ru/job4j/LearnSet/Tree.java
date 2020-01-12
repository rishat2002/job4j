package ru.job4j.LearnSet;

import java.sql.SQLOutput;
import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private E rootvalue;
    private Node<E> root;
    private int modCount = 0;

    public Tree(E rootvalue) {
        this.root = new Node<>(rootvalue);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean n = true;
        var s=this.findBy(parent);
        if (this.findBy(child).isPresent() || !s.isPresent()) {
            return n = false;
        }
        Node<E> newnod = new Node<>(child);
        s.get().add((newnod));
        modCount++;
        return n;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }
    public boolean isBinary() {
        boolean bin=true;
        Iterator iter=this.iterator();
        while (iter.hasNext()) {
            Node<E>par=this.findBy((E)iter.next()).get();
            if (par.leaves().size()>2) {
                bin=false;
                break;
            }
            ;
        }
        return bin;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
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
                Node<E> el = data.poll();
                for (Node<E> child : el.leaves()) {
                        data.offer(child);
                }
                value=el.getValue();

                return value;
            }
        };
    }
}

