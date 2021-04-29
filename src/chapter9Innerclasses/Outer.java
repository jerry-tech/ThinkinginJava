package chapter9Innerclasses;

//Exercise 1: (1) Write a class named Outer that contains an inner class named Inner.
//        Add a method to Outer that returns an object of type Inner. In main( ), create and
//        initialize a reference to an Inner.

public class Outer {
    class Inner {
        Inner() { System.out.println("Inner()"); }
    }
    Outer() { System.out.println("Question1()"); }
    // make an Inner from within a non-static method of outer class:
    Inner makeInner() {
        return new Inner();
    }
    public static void main(String[] args) {
        Outer o = new Outer();
        Inner i = o.makeInner();
    }
}
