package chapter19concurrency;


//Exercise 16: (1) Modify Exercise 15 to use explicit Lock objects
import java.util.concurrent.locks.*;

class checkTes1 { // all methods use same lock
    private Lock lock = new ReentrantLock();
    public void f1() {
        lock.lock();
        try {
            for(int i = 0; i < 5; i++) {
                System.out.print("f1()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
    public void g1() {
        lock.lock();
        try {
            for(int i = 0; i < 5; i++) {
                System.out.print("g1()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
    public void h1() {
        lock.lock();
        try {
            for(int i = 0; i < 5; i++) {
                System.out.print("h1()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
}

class checkTest2 { // each method has a different lock
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Lock lock3 = new ReentrantLock();

    public void f2() {
        lock1.lock();
        try {
            for(int i = 0; i < 5; i++) {
                System.out.print("f2()");
                Thread.yield();
            }
        } finally {
            lock1.unlock();
        }
    }
    public void g2() {
        lock2.lock();
        try {
            for(int i = 0; i < 5; i++) {
                System.out.print("g2()");
                Thread.yield();
            }
        } finally {
            lock2.unlock();
        }
    }
    public void h2() {
        lock3.lock();
        try {
            for(int i = 0; i < 5; i++) {
                System.out.print("h2()");
                Thread.yield();
            }
        } finally {
            lock3.unlock();
        }
    }
}

public class Question16 {
    public static void main(String[] args) {
        final checkTes1 st1 = new checkTes1();
        final checkTest2 st2 = new checkTest2();
        new Thread() {
            public void run() {
                st1.f1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.g1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.h1();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.f2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.g2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.h2();
            }
        }.start();
    }
}
