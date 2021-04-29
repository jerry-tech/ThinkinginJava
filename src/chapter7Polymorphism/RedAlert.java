package chapter7Polymorphism;

/**
 * Exercise 16:    (3) Following the example in Transmogrify.java, create a Starship class containing an
 *      AlertStatus reference that can indicate three different states. Include methods to change the states.
 *
 *      @see Starship
 *      @see AlertStatus
 *      @see GreenAlert
 *      @see YellowAlert
 *      @see Question7
 */
public class RedAlert extends AlertStatus {

    public void alert() {
        System.out.println("Red Alert");
    }
}
