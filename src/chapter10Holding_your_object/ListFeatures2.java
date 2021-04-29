package chapter10Holding_your_object;

//Exercise 6: (2) Modify ListFeatures.java so that it uses Strings instead of Pets, and
//        explain any difference in results

import java.util.*;

public class ListFeatures2 {
    
    public static void main(String[] args) {
        Random rand = new Random();
        List<String> ls = new ArrayList<String>();
        System.out.print("0: " + ls);
        Collections.addAll(ls, "oh", "what", "a", "beautiful", "Manila", "Monday", "morning");
        System.out.print("1: " + ls);
        String h = new String("hi");
        ls.add(h);
        System.out.print("2: " + ls);
        System.out.print("3: " + ls.contains(h));
        // removes the first instance equivalent to String h:
        ls.remove(h);
        System.out.print("3.5: " + ls);
        String p = ls.size() > 2 ? ls.get(2) : null;
        System.out.print("4: " + p + " " +  ls.indexOf(p));
        String cy = new String("cy");
        System.out.print("5: " + cy +" " + ls.indexOf(cy));
        System.out.print("6: " + ls.remove(cy));
        System.out.print("7: " + ls.remove(p));
        System.out.print("8: " + ls);
        if(ls.size() > 3)
            ls.add(3, "wonderful");
        System.out.print("9: " + ls);
        if(ls.size() < 4) {
            List<String> s =
                    Arrays.asList("let's", "jump", "in", "here");
            ls.addAll(0, s);
        }
        List<String> sub = ls.subList(1, 4);
        System.out.print("sublist: " + sub);
        System.out.print("10: " + ls.containsAll(sub));
        // will also sort sub elements within ls:
        Collections.sort(sub);
        System.out.print("sorted sublist: " + sub);
        System.out.print("11: " + ls.containsAll(sub));
        System.out.print("11.25: " + ls);
        // will also shuffle sub elements within ls:
        Collections.shuffle(sub, rand);
        System.out.print("11.5: " + ls);
        System.out.print("shuffled sublist: " + sub);
        System.out.print("12: " + ls.containsAll(sub));
        List<String> copy = new ArrayList<String>(ls);
        System.out.print("12.5: " + ls);
        if(ls.size() < 5) {
            ls.add("two");
            ls.add("more");
        }
        sub = Arrays.asList(ls.get(1), ls.get(4));
        System.out.print("sub: " + sub);
        copy.retainAll(sub);
        System.out.print("13: " + copy);
        copy = new ArrayList<String>(ls);
        copy.remove(2);
        System.out.print("14: " + copy);
        copy.removeAll(sub);
        System.out.print("15: " + copy);
        if(copy.size() > 1) // to avoid out of bounds exception
            copy.set(1, "excellent");
        System.out.print("16: " + copy);
        if(copy.size() > 2)
            copy.addAll(2, sub);
        System.out.print("17: " + copy);
        System.out.print("18: " + ls.isEmpty());
        ls.clear();
        System.out.print("19: " + ls);
        System.out.print("20: " + ls.isEmpty());
        ls.addAll(0, sub);
        ls.addAll(2, sub);
        System.out.print("21: " + ls);
        Object[] o = ls.toArray();
        System.out.print("22: " + o[3]);
        String[] sa = ls.toArray(new String[0]);
        System.out.print("23: " + sa[3]);
    }
}
