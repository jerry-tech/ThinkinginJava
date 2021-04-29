package chapter7Polymorphism;

/**
 * Exercise 1:   (2) Create a Cycle class, with subclasses UniCycle, Bicycle and Tricycle. Demonstrate that an
 *      instance of each type can be upcast to Cycle via a ride( ) method.
 *
 *      @see Cycle
 *      @see UniCycle
 *      @see Bicycle
 *      @see Question7
 */
public class Tricycle extends Cycle {

    public String toString() {
        return "Tricycle";
    }

    /**
     * Exercise 5:  (1) Starting from Exercise 1, add a wheels( ) method in Cycle, which returns the number of
     *      wheels. Modify ride( ) to call wheels( ) and verify that polymorphism works.
     *
     *      @see Cycle
     *      @see Question7
     *      @see Bicycle
     *      @see UniCycle
     */
    public int wheels() {
        return 3;
    }
}
