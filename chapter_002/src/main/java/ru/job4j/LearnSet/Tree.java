package ru.job4j.LearnSet;

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
        if (this.findBy(child).isPresent() || !this.findBy(parent).isPresent()) {
            return n = false;
        }
        Node<E> newnod = new Node<>(child);
        this.findBy(parent).get().add((newnod));
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
    public List returnlist() {
        Queue<Node<E>> data = new LinkedList<>();
        ArrayList<Node<E>> list=new ArrayList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            list.add(el);
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
    }
        return list;
        }

    @Override
    public Iterator<E> iterator() {
        List<Node<E>>q=this.returnlist();
        return new Iterator<E>() {
            private int n=modCount;
            private List<Node<E>>qforiter=q;
            Iterator<Node<E>> it=q.iterator();
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public E next() {
                if (n != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                E value=it.next().getValue();
                return value;
            }
        };
    }
}

