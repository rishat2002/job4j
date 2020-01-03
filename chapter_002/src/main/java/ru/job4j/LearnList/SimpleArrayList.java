package ru.job4j.LearnList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<E> implements Iterable<E> {
    private int modCount = 0;
    private int size;
    private Node<E> first;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    public void addInEnd(E data) {
        if (size == 0) {
            this.first = new Node<>(data);
        } else {
            Node<E> result = this.first;
            for (int i = 0; i < size - 1; i++) {
                result = result.next;
            }
            result.next = new Node<>(data);
        }
        this.size++;
        this.modCount++;
    }

    public void delete() {
        Node<E> newLink = this.first.next;
        this.first = newLink;
        size--;
        modCount++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int getSize() {
        return this.size;
    }

    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            private int s = modCount;
            private int i = 0;
            Node<E> result = first;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (i < size) {
                     result = true;
                }
                return result;
            }

            @Override
            public E next() throws NoSuchElementException, ConcurrentModificationException {
                if (s != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                E obj = result.data;
                result = result.next;
                i++;
                return obj;
            }
        };
    }


}
