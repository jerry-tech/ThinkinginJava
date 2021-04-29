package chapter20concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Exercise 3: (1) Repeat Exercise 1 using the different types of executors shown in this
//        section.

class Ex3RunnerA implements Runnable {
    public Ex3RunnerA() {
        System.out.println("Constructing Ex3RunnerA");
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("Hi from Ex3RunnerA");
            Thread.yield();
        }
        System.out.println("Ex3RunnerA task complete.");
        return;
    }
}

class Ex3RunnerB implements Runnable {
    public Ex3RunnerB() {
        System.out.println("Constructing Ex3RunnerB");
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("Hi from Ex3RunnerB");
            Thread.yield();
        }
        System.out.println("Ex3RunnerB task complete.");
        return;
    }
}

class Ex3RunnerC implements Runnable {
    public Ex3RunnerC() {
        System.out.println("Constructing Ex3RunnerC");
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("Hi from Ex3RunnerC");
            Thread.yield();
        }
        System.out.println("Ex3RunnerC task complete.");
        return;
    }
}

public class Question3 {
    public static void main(String[] args) {
        ExecutorService exec1 = Executors.newCachedThreadPool();
        exec1.execute(new Ex3RunnerA());
        exec1.execute(new Ex3RunnerB());
        exec1.execute(new Ex3RunnerC());
        exec1.shutdown();
        ExecutorService exec2 = Executors.newFixedThreadPool(3);
        exec2.execute(new Ex3RunnerA());
        exec2.execute(new Ex3RunnerB());
        exec2.execute(new Ex3RunnerC());
        exec2.shutdown();
        ExecutorService exec3 = Executors.newSingleThreadExecutor();
        exec3.execute(new Ex3RunnerA());
        exec3.execute(new Ex3RunnerB());
        exec3.execute(new Ex3RunnerC());
        exec3.shutdown();
    }
}