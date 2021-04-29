package chapter7Polymorphism;

/**
 * Exercise 16:    (3) Following the example in Transmogrify.java, create a Starship class containing an
 *      AlertStatus reference that can indicate three different states. Include methods to change the states.
 *
 *      @see Starship
 *      @see AlertStatus
 *      @see Question7
 *      @see YellowAlert
 *      @see RedAlert
 */
public class GreenAlert extends AlertStatus {

    public void alert() {
        System.out.println("Status is Green");
    }
}
