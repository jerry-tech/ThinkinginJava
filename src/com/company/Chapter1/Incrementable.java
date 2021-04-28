package com.company.Chapter1;

public class Incrementable {

    static int i = 47;

    static void increment() {
        i++;
    }

    public static void main(String[] args) {
        increment();
        System.out.println(i);
        increment();
        System.out.println(i);
        increment();
        System.out.println(i);
    }
}
