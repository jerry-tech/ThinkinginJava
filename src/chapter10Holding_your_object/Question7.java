package chapter10Holding_your_object;

//Exercise 7: (3) Create a class, then make an initialized array of objects of your class. Fill
//        a List from your array. Create a subset of your List by using subList( ), then remove this
//        subset from your List.

import java.util.*;

class Tester {
    public static int counter = 0;
    private int id = counter++;
    public String toString() { return String.valueOf(id); }
}

public class Question7 {
    public static void main(String[] args) {
        Tester[] t = new Tester[10];
        for(int i = 0; i < t.length; i++)
            t[i] = new Tester();
        List<Tester> lt = new ArrayList<>();
        for(Tester x : t) lt.add(x);
        System.out.print("list of Tester: " + lt);
        List<Tester> sub = lt.subList(2, 6);
        System.out.print("subList: " + sub);
        // produces run time ConcurrentModificationException:
//         lt.removeAll(sub);
        // so, first make copy, remove sub, re-assign lt:
        List<Tester> copy = new ArrayList<>(lt);
        copy.removeAll(sub);
        System.out.print("copy: " + copy);
        lt = copy;
        System.out.print("list of Tester: " + lt);
    }
}