package chapter20concurrency;

//Exercise 25: (1) In the Chef class in Restaurant.java, return from run( ) after
//        calling shutdownNow( ) and observe the difference in behavior.

import java.util.concurrent.*;


class Meal {
    private final int orderNum;
    public Meal(int orderNum) { this.orderNum = orderNum; }
    public String toString() { return "Meal " + orderNum; }
}

class WaitPerson25 implements Runnable {
    private Question25 restaurant;
    public WaitPerson25(Question25 r) { restaurant = r; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal == null)
                        wait(); // ... for the chef to produce a meal
                }
                System.out.print("WaitPerson25 got " + restaurant.meal);
                synchronized(restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); // ready for another
                }
            }
        } catch(InterruptedException e) {
            System.out.print("WaitPerson25 interrupted");
        }
    }
}

class Chef25 implements Runnable {
    private Question25 restaurant;
    private int count = 0;
    public Chef25(Question25 r) { restaurant = r; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal != null)
                        wait(); // ... for the meal to be taken
                }
                if(++count == 10) {
                    System.out.print("Out of food, closing");
                    restaurant.exec.shutdownNow();
                    return; // now Chef25 won't make another meal
                }
                System.out.print("Order up! ");
                synchronized(restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch(InterruptedException e) {
            System.out.print("Chef25 interrupted");
        }
    }
}

public class Question25 {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson25 waitPerson = new WaitPerson25(this);
    Chef25 chef = new Chef25(this);
    public Question25() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }
    public static void main(String[] args) {
        new Question25();
    }
}