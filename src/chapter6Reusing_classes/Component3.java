package chapter6Reusing_classes;

/**
 * Exercise 9:  (2) Create a class called Root that contains an instance of each of the classes
 *      (that you also create) named Component1, Component2, and Component3. Derive a class Stem from Root that
 *      also contains an instance of each 'component.' All classes should have default constructors that print
 *      a message about that class.
 *
 *      @see Root
 *      @see Stem
 *      @see Component1
 *      @see Component2
 *      @see Question6
 */
public class Component3 {

    /**
     * Exercise 10:    (1) Modify the previous exercise so that each class only has non-default constructors.
     *
     *      @see Root
     *      @see Stem
     *      @see Component1
     *      @see Component2
     *      @see Question6
     */
    public Component3(int i) {
        System.out.println("Component3");
    }
}
