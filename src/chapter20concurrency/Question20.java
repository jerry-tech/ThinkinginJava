package chapter20concurrency;

//Exercise 20: (1) Modify CachedThreadPool.java so that all tasks receive an
//        interrupt( ) before they are completed.

import java.util.concurrent.*;

public class Question20 {
    public static void main(String[] args) throws Exception {
        System.out.println("Using LiftOff:");
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {

            Future<?> f = exec.submit(new Thread());
            f.cancel(true);
        }
        exec.shutdownNow();
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.println("Some tasks were not terminated");
        // Using modified LiftOff:
        System.out.println("\nUsing LiftOff20:");
        ExecutorService exec20 = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            Future<?> f = exec20.submit(new Thread());
            f.cancel(true);
        }
        exec20.shutdownNow();
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.println("Some tasks were not terminated");
    }
}