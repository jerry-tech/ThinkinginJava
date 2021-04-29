package chapter4Initialization_cleanup;

/**
 * Exercise 17:    (2) Create a class with a constructor that takes a String argument. During construction,
 *      print the argument. Create an array of object references to this class, but do not actually create
 *      objects to assign into the array. When you run the program, notice whether the initialization messages
 *      from the constructor calls are printed.
 *
 *      @see ExercisesFour
 */
public class Messages {

    /**
     * Create a class with a constructor that takes a String argument. During construction,
     *      print the argument.
     *
     * @param string
     * @see ExercisesFour
     */
    public Messages(String string) {
        System.out.println(string);
    }
}
