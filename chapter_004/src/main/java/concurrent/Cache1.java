package concurrent;
public class Cache1 {
    private static Cache1 cache;
    private synchronized static Cache1 instOf() {
        if (cache == null) {
            cache = new Cache1();
        }
        return cache;
    }
}
