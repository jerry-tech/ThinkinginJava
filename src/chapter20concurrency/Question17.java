package chapter20concurrency;

//Exercise 17: (2) Create a radiation counter that can have any number of remote sensors.

import java.util.concurrent.*;
import java.util.*;

class RadianCount {
    private int count = 0;
    private Random rand = new Random();
    public synchronized int increment() {
        return count++;
    }
    public synchronized int value() { return count; }
}

class Sensor implements Runnable {
    private static RadianCount count = new RadianCount();
    private static List<Sensor> sensors = new ArrayList<Sensor>();
    private int number = 0;
    private final int id;
    private static volatile boolean canceled = false;
    // Atomic operation on a volatile field:
    public static void cancel() { canceled = true; }
    public Sensor(int id) {
        this.id = id;
        sensors.add(this);
    }
    public void run() {
        while(!canceled) {
            synchronized(this) {
                ++number;
            }
            System.out.print(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch(InterruptedException e) {
                System.out.print("sleep interrupted");
            }
        }
        System.out.print("Stopping " + this);
    }
    public synchronized int getValue() { return number; }
    public String toString() {
        return "Sensor " + id + ": " + getValue();
    }
    public static int getTotalCount() {
        return count.value();
    }
    public static int sumSensors() {
        int sum = 0;
        for(Sensor sensor : sensors)
            sum += sensor.getValue();
        return sum;
    }
}

public class Question17 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++)
            exec.execute(new Sensor(i));
        TimeUnit.SECONDS.sleep(4);
        Sensor.cancel();
        exec.shutdown();
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.print("Some tasks were not terminated");
        System.out.print("Total: " + Sensor.getTotalCount());
        System.out.print("Sum of Sensors: " + Sensor.sumSensors());
    }
}
