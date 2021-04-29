package chapter6Reusing_classes;

/**
 * Exercise 5:  (1) Create two classes, A and B, with default constructors (empty argument lists) that announce
 *      themselves. Inherit a new class called C from A, and create a member of class B inside C. Do not create
 *      a constructor for C. Create an object of class C and observe the results.
 *
 *      @see A
 *      @see B
 *      @see Question6
 */
public class C extends B {

    /**
     * Exercise 7:  (1) Modify Exercise 5 so that A and B have constructors with arguments instead of default
     *      constructors. Write a constructor for C and perform all initialization within Cs constructor.
     *
     *      @see A
     *      @see B
     *      @see Question6
     */
    public C() {
        super("string");
    }
    public String toString() {
        return "C";
    }
}
