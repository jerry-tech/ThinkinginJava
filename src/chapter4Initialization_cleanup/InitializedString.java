package chapter4Initialization_cleanup;

/**
 * Exercise 2:  (2) Create a class with a String field that is initialized at the point of definition, and
 *      another one that is initialized by the constructor. What is the difference between the two approaches?
 *
 * Exercise 3:  (1) Create a class with a default constructor (one that takes no arguments) that prints a
 *      message. Create an object of this class.
 *
 *      @see ExercisesFour
 */
public class InitializedString {
    String string = "default";

    public InitializedString() {
        System.out.println(this.string);
    }

    public InitializedString(String string) {
        this.string = string;
        System.out.println(this.string);
    }
}
