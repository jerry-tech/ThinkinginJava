package chapter19concurrency;

import java.util.concurrent.*;
import java.util.*;


class Count {
    private int count = 0;
    private Random rand = new Random(47);
    // Remove the synchronized keyword to see counting fail:
    public synchronized int increment() {
        int temp = count;
        if(rand.nextBoolean()) // Yield half the time
            Thread.yield();
        return (count = ++temp);
    }
    public synchronized int value() { return count; }
}

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<Entrance>();
    private int number = 0;
    // Doesn't need synchronization to read:
    private final int id;
    private static volatile boolean canceled = false;
    // Atomic operation on a volatile field:
    public static void cancel() { canceled = true; }
    public Entrance(int id) {
        this.id = id;
        // Keep this task in a list. Also prevents
        // garbage collection of dead tasks:
        entrances.add(this);
    }
    public void run() {
        while(!canceled) {
            synchronized(this) { // uninterruptible
                ++number;
            }
            System.out.print(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch(InterruptedException e) {
                System.out.print("sleep interrupted");
                break; // need another way out (during sleep)
            }
        }
        System.out.print("Stopping " + this);
    }
    public synchronized int getValue() { return number; }
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }
    public static int getTotalCount() {
        return count.value();
    }
    public static int sumEntrances() {
        int sum = 0;
        for(Entrance entrance : entrances)
            sum += entrance.getValue();
        return sum;
    }
}

public class Question19 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new Entrance(i));
        // Run for a while, then stop and collect the data:
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.print("Some tasks were not terminated");
        System.out.print("Total: " + Entrance.getTotalCount());
        System.out.print("Sum of Entrances: " + Entrance.sumEntrances());
    }
}
