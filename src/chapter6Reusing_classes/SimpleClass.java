package chapter6Reusing_classes;

/**
 * Exercise 1:   (2) Create a simple class. Inside a second class, define a reference to an object of the first
 *      class. Use lazy initialization to instantiate this object.
 *
 *      @see Question6
 *      @see LazyClass
 */
public class SimpleClass {

    LazyClass lazyClass;

    public SimpleClass() {
        lazyClass = new LazyClass();
        System.out.println(lazyClass + " has been created inside " + this);
    }

    public String toString() {
        return "SimpleClass";
    }
}
