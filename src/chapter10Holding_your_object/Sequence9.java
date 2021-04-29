package chapter10Holding_your_object;

import java.util.ArrayList;
import java.util.Iterator;

//Exercise 9: (4) Modify innerclasses/Sequence.java so that Sequence works with an
//        Iterator instead of a Selector.

public class Sequence9 {
    private ArrayList<Object> items = new ArrayList<>();
    public void add(Object x) {
        items.add(x);
    }
    public Iterator iterator() {
        return items.iterator();
    }
    public static void main(String[] args) {
        Sequence9 sequence = new Sequence9();
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Iterator it = sequence.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}

