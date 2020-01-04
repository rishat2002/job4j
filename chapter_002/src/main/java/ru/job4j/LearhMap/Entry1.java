package ru.job4j.LearhMap;

class Entry1<K, V> {
    private K key;
    private V value;

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public Entry1(V key, K value) {
        this.key = (K) key;
        this.value = (V) value;
    }
}