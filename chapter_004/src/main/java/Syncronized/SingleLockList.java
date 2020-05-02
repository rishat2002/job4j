package Syncronized;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.LearnList.ArrList;

import java.util.Iterator;
@ThreadSafe
public class SingleLockList<T> implements Iterable<T> {
    @GuardedBy("this")
    private ArrList<T>list=new ArrList<T>();
    public synchronized void add(T value) {
        list.add(value);
    }

    public synchronized T get(int index) {
        return list.get(index);
    }
    @Override
    public synchronized Iterator<T> iterator() {
        return list.iterator();
    }
}
