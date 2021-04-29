package chapter7Polymorphism;

/**
 * Exercise 16:    (3) Following the example in Transmogrify.java, create a Starship class containing an
 *      AlertStatus reference that can indicate three different states. Include methods to change the states.
 *
 *      @see Starship
 *      @see AlertStatus
 *      @see GreenAlert
 *      @see Question7
 *      @see RedAlert
 */
public class YellowAlert extends AlertStatus {

    public void alert() {
        System.out.println("Yellow Alert");
    }
}
