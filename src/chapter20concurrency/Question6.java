package chapter20concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Exercise 6: (2) Create a task that sleeps for a random amount of time between 1 and 10
//        seconds, then displays its sleep time and exits. Create and run a quantity (given on the
//        command line) of these tasks.

public class Question6 implements Runnable {
    Random rand = new Random();
    public void run() {
        try {
            int t = 1000 * rand.nextInt(10);
            TimeUnit.MILLISECONDS.sleep(t);
            System.out.println("Slept " + t/1000 + " seconds");
            return;
        } catch(InterruptedException e) {
            System.err.println("Interrupted");
        }

    }
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Usage: enter a number");
        }
        if(args.length == 1) {
            int n = Integer.parseInt(args[0]);
            ExecutorService exec = Executors.newCachedThreadPool();
            for(int i = 0; i < n; i++)
                exec.execute(new Question6());
            exec.shutdown();
        }
    }
}
