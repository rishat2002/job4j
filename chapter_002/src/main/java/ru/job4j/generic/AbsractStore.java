package ru.job4j.generic;

public abstract class AbsractStore<T extends Base> implements Store<T> {
  SimpleArray<T> simple;
    public AbsractStore(int size) {
        this.simple = new SimpleArray<T>(size);
    }
    public int searchForId(String id ) {
     int l=-1;
        for (int i=0;i<simple.getArray().length;i++) {
            if (simple.get(i)!=null && simple.get(i).getId().equals(id)) {
                l=i;
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
        if (searchForId(id)==-1) {
            return false;
        }
        else {
            simple.set(searchForId(id),model);
            return true;
        }
    }

    @Override
    public boolean delete(String id) {
        if (searchForId(id)==-1) {
            return false;
        }
        else {
            simple.remove(searchForId(id));
            return true;
        }
    }

    @Override
    public T findById(String id) {
        T obj=null;
        if (searchForId(id)!=-1) {
            obj=simple.get(searchForId(id));
        }
        return obj;
    }
}
