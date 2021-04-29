package chapter6Reusing_classes;

/**
 *  Exercise 8:  (1) Create a base class with only a non-default constructor, and a derived class with both a
 *      default (no-arg) and non-default constructor. In the derived-class constructors, call the
 *      base-class constructor.
 *
 *      @see Question6
 *      @see Derived
 */
public class Derived extends MyBaseClass {

    public Derived() {
        super("string");
    }

    public Derived(int i) {
        super("string");
    }
}
