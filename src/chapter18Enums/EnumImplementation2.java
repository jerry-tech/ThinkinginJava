package chapter18Enums;

import java.util.*;

//Exercise 2: (2) Instead of implementing an interface, make next( ) a static method.
//        What are the benefits and drawbacks of this approach?

enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private static Random rand = new Random();
    public static CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation2 {
    public static void main(String[] args) {
        // Choose any instance:
        CartoonCharacter cc = CartoonCharacter.BOB;
        for(int i = 0; i < 10; i++) {
            System.out.print(cc.next());
            System.out.print((i < 9) ? ", " : "");
        }
    }
}