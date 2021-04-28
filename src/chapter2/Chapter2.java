package chapter2;

import static chapter2.PassObject.f;

public class Chapter2 {

    public static void main(String[] args) {
        /**
         * Exercise 1:   (1) Write a program that uses the short and normal form of print statement.
         */
        System.out.print("Hello");

        /**
         * Exercise 2:  (1) Create a class containing a float and use it to demonstrate aliasing.
         *  @see Alias
         */

        Alias alias = new Alias(3);
        Alias alias1 = new Alias(4);

        System.out.println("1: alias: " + alias.t + ", alias1: " + alias1.t);
        alias = alias1;
        System.out.println("2: alias: " + alias.t + ", alias1: " + alias1.t);
        alias.t = 9;
        System.out.println("3: alias: " + alias.t + ", alias1: " + alias1.t);

        /**
         * Exercise 3:  (1) Create a class containing a float and use it to demonstrate aliasing during method calls.
         *      @see Letter
         */
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1: x.c: " + x.c);
        f(x);
        System.out.println("2: x.c: " + x.c);


        /**
         * Exercise 4:  (2) Write a program that calculates velocity using a constant distance and a constant time.
         *      @see Velocity
         */
        Velocity velocity = new Velocity();

        /**
         * Exercise 7:  (3) Write a program that simulates coin-flipping.
         *      @see Coin
         */

        Coin coin = new Coin();
        System.out.println(coin.flip());
        
    }
}
