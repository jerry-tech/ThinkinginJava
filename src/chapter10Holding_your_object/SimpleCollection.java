package chapter10Holding_your_object;

import java.util.HashSet;
import java.util.Set;

//Exercise 2: (1) Modify SimpleCollection.java to use a Set for c
public class SimpleCollection {

    public static void main(String[] args) {
        Set<Integer> c = new HashSet<>();
        for(int i = 0; i < 10; i++)
            c.add(i); // Autoboxing
        for(Integer i : c)
            System.out.print(i + ", ");
    }
}
