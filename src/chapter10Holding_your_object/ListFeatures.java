package chapter10Holding_your_object;

import java.util.*;

//Exercise 5: (3) Modify ListFeatures.java so that it uses Integers (remember
//        autoboxing!) instead of Pets, and explain any difference in results.

public class ListFeatures {
    // method to make a List<Integer> with random values < n:
    public static List<Integer> listOfRandInteger(int length, int n) {
        Random rand = new Random();
        List<Integer> li = new ArrayList<Integer>();
        for(int i = 0; i < length; i++)
            li.add(rand.nextInt(n));
        return li;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> li = listOfRandInteger(7, 10);
        System.out.print("1: " + li);
        Integer h = new Integer(rand.nextInt(10));
        li.add(h);
        System.out.print("2: " + li);
        System.out.print("3: " + li.contains(h));
        // removes the first instance equivalent to Integer h:
        li.remove(h);
        System.out.print("3.5: " + li);
        Integer p = li.get(2);
        System.out.print("4: " + p + " " +  li.indexOf(p));
        Integer cy = new Integer(rand.nextInt(10));
        System.out.print("5: " + cy +" " + li.indexOf(cy));
        System.out.print("6: " + li.remove(cy));
        System.out.print("7: " + li.remove(p));
        System.out.print("8: " + li);
        li.add(3, new Integer(rand.nextInt(10)));
        System.out.print("9: " + li);
        List<Integer> sub = li.subList(1, 4);
        System.out.print("sublist: " + sub);
        System.out.print("10: " + li.containsAll(sub));
        // will also sort sub elements within li:
        Collections.sort(sub);
        System.out.print("sorted sublist: " + sub);
        System.out.print("11: " + li.containsAll(sub));
        System.out.print("11.25: " + li);
        // will also shuffle sub elements within li:
        Collections.shuffle(sub, rand);
        System.out.print("11.5: " + li);
        System.out.print("shuffled sublist: " + sub);
        System.out.print("12: " + li.containsAll(sub));
        List<Integer> copy = new ArrayList<Integer>(li);
        System.out.print("12.5: " + li);
        sub = Arrays.asList(li.get(1), li.get(4));
        System.out.print("sub: " + sub);
        copy.retainAll(sub);
        System.out.print("13: " + copy);
        copy = new ArrayList<Integer>(li);
        copy.remove(2);
        System.out.print("14: " + copy);
        copy.removeAll(sub);
        System.out.print("15: " + copy);
        if(copy.size() > 1) // to avoid out of bounds exception
            copy.set(1, 8); // autoboxing int -> Integer
        System.out.print("16: " + copy);
        if(copy.size() > 2)
            copy.addAll(2, sub);
        System.out.print("17: " + copy);
        System.out.print("18: " + li.isEmpty());
        li.clear();
        System.out.print("19: " + li);
        System.out.print("20: " + li.isEmpty());
        li.addAll(listOfRandInteger(4, 10));
        System.out.print("21: " + li);
        Object[] o = li.toArray();
        System.out.print("22: " + o[3]);
        Integer[] ia = li.toArray(new Integer[0]);
        System.out.print("23: " + ia[3]);
    }
}
