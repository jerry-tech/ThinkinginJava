package chapter10Holding_your_object;

import java.util.ArrayList;
import java.util.Iterator;

//Exercise 8: (1) Modify Exercise l so it uses an Iterator to move through the List while
//        calling hop( ).

class Question8 {
    private int gerbilNumber;
    public Question8(int i) {
        gerbilNumber = i;
    }
    public void hop() {
        System.out.println("Gerbil " + gerbilNumber + " hops");
    }
}

public class Gebril2 {
    public static void main(String[] args) {
        ArrayList<Question8> gerbils = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            gerbils.add(new Question8(i));
        Iterator<Question8> it = gerbils.iterator();
        while (it.hasNext())
            it.next().hop();
    }
}