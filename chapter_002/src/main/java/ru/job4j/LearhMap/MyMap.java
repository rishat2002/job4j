package ru.job4j.LearhMap;

import java.util.*;

public class MyMap<K, V> implements Iterable {
    public Entry1[] mass;
    private int i = 0;
    private int modCount = 0;

    public MyMap() {
        this.mass = new Entry1[8];
    }

    public boolean insert(K k, V v) {
        boolean n = true;
        if (this.searchForKey(k) != null) {
            n = false;
            return n;
        }
        Entry1 entry1 = new Entry1(k, v);
        int index = Math.abs(k.hashCode() % mass.length);
        if (i < mass.length) {
            mass[index] = entry1;
        } else {
            Entry1[] biggermass = new Entry1[mass.length * 2];
            System.arraycopy(mass, 0, biggermass, 0, mass.length);
            mass = biggermass;
            mass[index] = entry1;
        }
        modCount++;
        i++;
        return n;
    }

    public V get(K key) {
        V rsl = null;
        if (this.searchForKey(key) != null) {
            rsl = (V) this.searchForKey(key).getValue();
        }
        return rsl;
    }

    public Entry1 searchForKey(K key) {
            return mass[Math.abs(key.hashCode() % mass.length)];
    }

    public boolean delete(K key) {
        boolean n = true;
        if (this.searchForKey(key) == null) {
            n = false;
        } else {
            for (int i = 0; i < mass.length; i++) {
                if (mass[i] != null && mass[i].equals(this.searchForKey(key))) {
                    mass[i] = null;
                }
            }
            modCount++;
        }
        return n;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int s = modCount;
            private Entry1[] massfornext = mass.clone();
            private Entry1[] massforhasnext = mass.clone();

            @Override
            public boolean hasNext() {
                boolean result = false;
                for (int i = 0; i < massforhasnext.length; i++) {
                    if (massforhasnext[i] != null) {
                        massforhasnext[i] = null;
                        result = true;
                        break;
                    }
                }
                return result;
            }

            @Override
            public Entry1 next() throws NoSuchElementException, ConcurrentModificationException {
                Entry1 l = null;
                if (s != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                for (int i = 0; i < massfornext.length; i++) {
                    if (massfornext[i] != null) {
                        l = massfornext[i];
                        massfornext[i] = null;
                        break;
                    }
                }
                return l;
            }
        };
    }

}
