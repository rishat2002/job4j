package newpart;

import org.junit.Test;

import java.util.Random;

public class SimpleBlockingQueueTest  {
     @Test
    public void testOffer() throws InterruptedException {
         SimpleBlockingQueue<Integer> s=new SimpleBlockingQueue<>(10);
         Thread producer = new Thread(new Runnable() {
             @Override
             public void run() {
                 Random r=new Random();
                 while (true) {
                     try {
                         s.offer(r.nextInt(150));
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         });
         Thread consumer =new Thread(new Runnable() {
             @Override
             public void run() {
                 while (true) {
                     try {System.out.println(s.getSize()+" before size");
                         System.out.println(s.poll());
                         Thread.sleep(5000);
                         System.out.println(s.getSize()+" after size");
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         });
         producer.start();
         consumer.start();
         producer.join();
         consumer.join();
    }
}