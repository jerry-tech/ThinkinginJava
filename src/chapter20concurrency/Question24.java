package chapter20concurrency;

//Exercise 24: (1) Solve a single-producer, single-consumer problem using wait( ) and
//        notifyAll( ). The producer must not overflow the receiver’s buffer, which can happen if the
//        producer is faster than the consumer. If the consumer is faster than the producer, then it
//        must not read the same data more than once. Do not assume anything about the relative
//        speeds of the producer or consumer.

import java.util.*;
import java.util.concurrent.*;


class Item {
    private final int itemNum;
    public Item(int itemNum) { this.itemNum = itemNum; }
    public String toString() { return "Item " + itemNum; }
}

class Producer implements Runnable {
    private int count = 0;
    Question24 market;
    Producer(Question24 m) { market = m; }
    protected int getCount() { return count; }
    public void run() {
        while(!Thread.interrupted()) {
            try {
                while(count < 100) {
                    Item item = new Item(++count);
                    if(market.storage.offer(item)) {
                        System.out.println("Produced " + item);
                        // Notify consumer that Item available:
                        synchronized(market.consumer) {
                            market.consumer.notifyAll();
                        }
                    }
                    // Storage holds only 10 Items:
                    synchronized(this) {
                        while(!(market.storage.size() < 10)) {
                            wait();
                        }
                    }
                }
                // Stop production after 100 Items:
                System.out.println("Produced " + count + " Items"
                        + "\nStopping production");
                market.exec.shutdownNow();
            } catch(InterruptedException e) {
                System.out.println("Producer interrupted");
                System.out.println("Produced " + count + " Items");
            }
        }
    }
}

class Consumer implements Runnable {
    int consumed = 0;
    Question24 market;
    List<Item> cart = new ArrayList<Item>();
    Consumer(Question24 m) { market = m; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // Cannot consume more Items than produced:
                synchronized(this) {
                    while(!(cart.size() < market.producer.getCount())) {
                        wait();
                    }
                }
                // Move Item from storage to cart:				
                if(cart.add(market.storage.poll())) {
                    System.out.println("Consuming Item " + ++consumed);
                    // Notify producer - ready for more:
                    synchronized(market.producer) {
                        market.producer.notifyAll();
                    }
                }
            }
        }
        catch(InterruptedException e) {
            System.out.println("Consumer interrupted");
            System.out.println("Consumed " + consumed + " Items");
        }
    }
}


public class Question24 {
    ExecutorService exec = Executors.newCachedThreadPool();
    Queue<Item> storage = new LinkedList<Item>();
    Producer producer = new Producer(this);
    Consumer consumer = new Consumer(this);
    public Question24() {
        exec.execute(producer);
        exec.execute(consumer);
    }
    public static void main(String[] args) {
        new Question24();
    }
}
