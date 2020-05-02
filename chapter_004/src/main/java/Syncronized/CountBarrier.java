package Syncronized;

public class CountBarrier {
    private final Object monitor = this;

    private final int total;

    private int count = 0;

    public CountBarrier(final int total) {
        this.total = total;
    }

    public synchronized void count() {
        System.out.println("Hello");
        count++;
    }

    public synchronized void await() throws InterruptedException {
        if (total == count) {
            this.notifyAll();
            System.out.println("thread wake up");
        } else {
            System.out.println("thread sleep");
            this.wait();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountBarrier c = new CountBarrier(5);
        Thread t1 = new Thread(() -> {
            while (true) {
                c.count();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                while (true) {
                    c.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t1.start();
        t1.join();
        t2.join();
    }
}
