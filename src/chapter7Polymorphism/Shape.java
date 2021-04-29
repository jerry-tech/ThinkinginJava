package chapter7Polymorphism;

/**
 * Exercise 2:  (1) Add the @Override annotation to the shapes example.
 *
 *      @see Shapes
 *      @see RandomShapeGenerator
 *      @see Question7
 *      @see Triangle
 *      @see Square
 *      @see Circle
 */
public class Shape {
    public void draw() {}
    public void erase() {}

    /**
     *   Exercise 3:  (1) Add a new method in the base class of Shapes.java that prints a message, but do not
     *          override it in the derived classes. Explain what happens. Now override it in one of the derived
     *          classes but not the others, and see what happens. Finally, override it in all the derived classes.
     *
     *          @see Question7
     *          @see Circle
     *          @see Square
     *          @see Triangle
     */
    public String toString() {
        return "Shape";
    }
}
