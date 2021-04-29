package chapter2operators;

import java.util.Random;

/**
 * Exercise 7:  (3) Write a program that simulates coin-flipping.
 *      @see Chapter2
 */
public class Coin {
    Random rn;

    public Coin(){
        rn = new Random();
    }

    public String flip() {
        return (rn.nextInt() + 1) % 2 == 0 ? "tails" : "heads";
    }
}
