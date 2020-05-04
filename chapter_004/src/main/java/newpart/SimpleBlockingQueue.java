package newpart;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

@ThreadSafe
public class SimpleBlockingQueue<T> {
    private int size;

    public int getSize() {
        return size;
    }

    public SimpleBlockingQueue(int size) {
        this.size = size;
    }

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    public synchronized void offer(T value) throws InterruptedException {
        if (queue.size() >= size) {
            this.wait();
        } else {
            this.notifyAll();
            queue.offer(value);
        }
    }

    public synchronized T poll() throws InterruptedException {
        T p = null;
        if (queue.isEmpty()) {
            this.wait();
        } else {
            this.notifyAll();
            p = queue.poll();
        }
        return p;
    }

    public static void main(String[] args) throws InterruptedException {

    }
}