package chapter20concurrency;

import java.util.concurrent.*;

//Exercise 23: (7) Demonstrate that WaxOMatic.java works successfully when you use
//        notify( ) instead of notifyAll( ).

class Car1 {
    private boolean waxOn = false;
    public synchronized void waxed() {
        waxOn = true; // Ready to buff
        // notifyAll();
        notify();
    }
    public synchronized void buffed() {
        waxOn = false; // Ready for another coat of wax
        // notifyAll();
        notify();
    }
    public synchronized void waitForWaxing() throws InterruptedException {
        while(waxOn == false) wait();
    }
    public synchronized void waitForBuffing() throws InterruptedException {
        while(waxOn == true) wait();
    }
}

class WaxOn1 implements Runnable {
    private Car1 car;
    public WaxOn1(Car1 c) { car = c; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                System.out.print("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch(InterruptedException e) {
            System.out.print("Exiting via interrupt");
        }
        System.out.print("Ending Wax On task");
    }
}

class WaxOff1 implements Runnable {
    private Car1 car;
    public WaxOff1(Car1 c) { car = c; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.print("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch(InterruptedException e) {
            System.out.print("Exiting via interrupt");
        }
        System.out.print("Ending Wax Off task");
    }
}

public class Question23 {
    public static void main(String[] args) throws Exception {
        Car1 car = new Car1();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff1(car));
        exec.execute(new WaxOn1(car));
        TimeUnit.SECONDS.sleep(5); // Run for a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
}	
 