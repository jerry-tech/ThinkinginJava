package chapter10Holding_your_object;

//Exercise 1: (2) Create a new class called Gerbil with an int gerbilNumber that’s
//        initialized in the constructor. Give it a method called hop( ) that displays which gerbil
//        number this is, and that it’s hopping. Create an ArrayList and add Gerbil objects to the
//        List. Now use the get( ) method to move through the List and call hop( ) for each Gerbil.


import java.util.*;

class Question1 {
    private int gerbilNumber;

    public Question1(int i) {
        gerbilNumber = i;
    }

    public void hop() {
        System.out.println("Gerbil " + gerbilNumber + " hops");
    }
}

public class Gerbil {
    public static void main(String[] args) {
        ArrayList<Question1> gerbils = new ArrayList<>();
        //using foreach
        for (Question1 g : gerbils) {
            g.hop();
        }
    }
}
