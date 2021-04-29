package chapter19concurrency;

/** Implement a Runnable. Inside run(), print a message, and then call yield().
 * Repeat this three times, and then return from run(). Put a startup message in
 * the constructor and a shutdown message when the task terminates. Create a
 * number of these tasks and drive them using threads.
 **/

class RunnerA implements Runnable {
    public RunnerA() {
        System.out.println("Constructor RunnerA");
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("RunnerA in a running state.");
            Thread.yield();
        }
        System.out.println("RunnerA task complete.");
        return;
    }
}

class RunnerB implements Runnable {
    public RunnerB() {
        System.out.println("Constructor RunnerB");
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("RunnerB in a running state.");
            Thread.yield();
        }
        System.out.println("RunnerB task complete.");
        return;
    }
}

class RunnerC implements Runnable {
    public RunnerC() {
        System.out.println("Constructor RunnerC");
    }
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("RunnerC in a running state.");
            Thread.yield();
        }
        System.out.println("RunnerC task complete.");
        return;
    }
}

public class Question1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnerA());
        Thread thread2 = new Thread(new RunnerB());
        Thread thread3 = new Thread(new RunnerC());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
