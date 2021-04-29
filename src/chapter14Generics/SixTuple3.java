package chapter14Generics;

//Exercise 3 : (1) Create and test a SixTuple generic.

class Robot1 {
}

class Amphibian {
}

class Vehicle {
}

class FiveTuple<A, B, C, D, E> {
    public final A first;
    public final B second;
    public final C Third;
    public final D fourth;
    public final E fifth;

    public FiveTuple(A first, B second, C third, D fourth, E fifth) {
        this.first = first;
        this.second = second;
        Third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " +
                Third + ", " + fourth + ", " + fifth + ")";
    }
}

class SixTuple<A, B, C, D, E, F>
        extends FiveTuple<A, B, C, D, E> {
    public final F sixth;

    public SixTuple(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e);
        sixth = f;
    }

    public String toString() {
        return "(" + first + ", " + second + ", " +
                Third + ", " + fourth + ", " + fifth + ", " + sixth + ")";
    }
}

public class SixTuple3 {
    static SixTuple<Robot1, Vehicle, Amphibian, String, Integer, Double> f() {
        return new SixTuple<Robot1, Vehicle, Amphibian, String, Integer, Double>(
                new Robot1(), new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        SixTuple<Robot1, Vehicle, Amphibian, String, Integer, Double> st = f();
        System.out.println(st);
        System.out.println(f());
    }
}