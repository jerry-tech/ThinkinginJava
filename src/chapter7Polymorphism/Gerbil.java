package chapter7Polymorphism;

/**
 * Exercise 9:  (3) Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster, etc. In the base class,
 *      provide methods that are common to all Rodents, and override these in the derived classes to perform
 *      different behaviors depending on the specific type of Rodent. Create an array of Rodent, fill it with
 *      different specific types of Rodents, and call your base-class methods to see what happens.
 *
 *      @see Rodent
 *      @see Hamster
 *      @see Question7
 *      @see Mouse
 */
public class Gerbil extends Rodent {

    Brass brass = new Brass();

    public Gerbil() {
        System.out.println("Create Gerbil");
    }

    public void move() {
        System.out.println("To the pellet dish");
    }

    public void gnaw() {
        System.out.println("Into the pellets.");
    }

    /**
     * Exercise 12:    (3) Modify Exercise 9 so that it demonstrates the order of initialization of the base classes
     *      and derived classes. Now add member objects to both the base and derived classes, and show the order in
     *      which their initialization occurs during construction.
     *
     *      @see Rodent
     *      @see Hamster
     *      @see Mouse
     *      @see Question7
     *      @see Instrument
     *      @see Stringed
     *      @see Reed
     *      @see Brass
     *      @see Percussion
     */
    public void dispose() {
        System.out.println("Dispose of Gerbil");
        brass.dispose();
        super.dispose();
    }
}
