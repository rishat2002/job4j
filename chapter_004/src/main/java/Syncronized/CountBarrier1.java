package Syncronized;

public class CountBarrier1 {
    private final Object monitor = this;

    private final int total;

    private int count = 0;

    public CountBarrier1(final int total) {
        this.total = total;
    }

    public synchronized void count() {
        count++;
    }

    public synchronized void await() throws InterruptedException {
        if (total == count) {
            this.notifyAll();
        } else {
            this.wait();
        }
    }

    public static void main(String[] args) throws InterruptedException {

    }
}
