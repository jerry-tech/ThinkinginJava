package chapter6Reusing_classes;

/**
 * If you do not call the base-class constructor in BoardGame( ), the compiler will complain that it can not find
 *      a constructor of the form Game( ). In addition, the call to the base-class constructor must be the first
 *      thing you do in the derived-class constructor. (The compiler will remind you if you get it wrong.)
 *
 *      Exercise 6:  (1) Using Chess.java, prove the statements in the previous paragraph.
 *      @see Question6
 *      @see BoardGame
 *      @see Game
 */
public class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor");
    }
}
