package chapter2;

public class Dog {
    String name;
    String says;

    public Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }

    public void speak() {
        System.out.println(name + " says " + says);
    }

    /**
     * Exercise 5:  (2) Create a class called Dog with an overloaded bark( ) method. This method should be
     *      overloaded based on various primitive data types, and print different types of barking, howling, etc.,
     *      depending on which overloaded version is called. Write a main( ) that calls all the different versions.
     *
     *      @see chapter.four.exercises.ExercisesFour
     */
    public void bark() {
        System.out.println(this.says);
    }

    /**
     * Exercise 5:  (2) Create a class called Dog with an overloaded bark( ) method. This method should be
     *      overloaded based on various primitive data types, and print different types of barking, howling, etc.,
     *      depending on which overloaded version is called. Write a main( ) that calls all the different versions.
     *
     *      @see chapter.four.exercises.ExercisesFour
     */
    public void bark(String bark) {
        System.out.println(bark);
    }

    /**
     * Exercise 6:  (1) Modify the previous exercise so that two of the overloaded methods have two arguments
     *      (of two different types), but in reversed order relative to each other. Verify that this works.
     *
     *      @see chapter.four.exercises.ExercisesFour
     */
    public void fetch(int thrown, String obj) {
        System.out.println("retrieve " + obj + " " + thrown + " times");
    }

    /**
     * Exercise 6:  (1) Modify the previous exercise so that two of the overloaded methods have two arguments
     *      (of two different types), but in reversed order relative to each other. Verify that this works.
     *
     *      @see chapter.four.exercises.ExercisesFour
     */
    public void fetch(String obj, int thrown) {
        fetch(thrown, obj);
    }
}

