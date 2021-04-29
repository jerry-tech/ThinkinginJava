package chapter19concurrency;

import java.util.concurrent.*;
import java.util.*;
import static java.lang.Thread.*;

//Exercise 9: (3) Modify SimplePriorities.java so that a custom ThreadFactory sets
//        the priorities of the threads.

class SimplePriorities9ThreadFactory implements ThreadFactory {
    Random rand = new Random();
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        int i = rand.nextInt(3);
        switch(i) {
            case 0 : t.setPriority(MIN_PRIORITY); break;
            case 1 : t.setPriority(NORM_PRIORITY); break;
            case 2 : t.setPriority(MAX_PRIORITY); break;
            default:
        }
        return t;
    }
}

public class Question9 implements Runnable {
    private int countDown = 5;
    private volatile double d; // No optimization
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }
    public void run() {
        while(true) {

            for(int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if(i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown == 0) return;
        }
    }
    public static void main(String[] args) throws Exception {
        ExecutorService exec =
                Executors.newCachedThreadPool(new SimplePriorities9ThreadFactory());
        for(int i = 0; i < 5; i++)
            exec.execute(new Question9());
        exec.execute(new Question9());
        exec.shutdown();

    }
}
