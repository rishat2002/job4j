package ru.job4j.generic;

public abstract class AbsractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simple;

    public AbsractStore(int size) {
        this.simple = new SimpleArray<T>(size);
    }

    public int searchForId(String id) {
        int l = -1;
        int i = 0;
        for (T model : this.simple) {
            if (model != null && model.getId().equals(id)) {
                i++;
                l = i;
            }
        }
        return l;
    }

    @Override
    public void add(T model) {
        simple.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = true;
        if (searchForId(id) == -1) {
            result = false;
        } else {
            simple.set(searchForId(id), model);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = true;
        if (searchForId(id) == -1) {
            result = false;
        } else {
            simple.remove(searchForId(id));
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T obj = null;
        if (searchForId(id) != -1) {
            obj = simple.get(searchForId(id));
        }
        return obj;
    }
}
