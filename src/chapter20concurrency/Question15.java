package chapter20concurrency;

//Exercise 15: (1) Create a class with three methods containing critical sections that all
//        synchronize on the same object. Create multiple tasks to demonstrate that only one of these
//        methods can run at a time. Now modify the methods so that each one synchronizes on a
//        different object and show that all three methods can be running at once.

class checkTest1 { // all methods synchronized on this
    public void f1() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.print("Nigeria");
                Thread.yield();
            }
        }
    }

    public void g1() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.print("Gambia");
                Thread.yield();
            }
        }
    }

    public void h1() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.print("Malawi");
                Thread.yield();
            }
        }
    }
}

class CheckTest2   { // methods synchronized on different objects
    private Object syncObject1 = new Object();
    private Object syncObject2 = new Object();
    private Object syncObject3 = new Object();

    public void f2() {
        synchronized (syncObject1) {
            for (int i = 0; i < 5; i++) {
                System.out.print("England");
                Thread.yield();
            }
        }
    }

    public void g2() {
        synchronized (syncObject2) {
            for (int i = 0; i < 5; i++) {
                System.out.print("Spain");
                Thread.yield();
            }
        }
    }

    public void h2() {
        synchronized (syncObject3) {
            for (int i = 0; i < 5; i++) {
                System.out.print("Italy");
                Thread.yield();
            }
        }
    }
}

public class Question15 {
    public static void main(String[] args) {
        final checkTest1 st1 = new checkTest1();
        final CheckTest2 st2 = new CheckTest2();
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