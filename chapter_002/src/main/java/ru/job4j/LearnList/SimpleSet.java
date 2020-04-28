package ru.job4j.LearnList;

public class SimpleSet<T> extends ArrList<T> {

    private ArrList<T> arr = new ArrList<T>();

    public void add(T value) {
        if (this.equalObject(value) == true) {
            arr.add(value);
        }
    }

    public boolean equalObject (T value) {
        boolean n=true;
        for (int i = 0; i < arr.getIndex(); i++) {
            if (value.equals(arr.get(i))) {
                n = false;
                break;
            }
        }
        return n;
    }

    public ArrList<T> getArr() {
        return arr;
    }
}
