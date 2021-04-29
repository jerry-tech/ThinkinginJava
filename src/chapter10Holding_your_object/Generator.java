package chapter10Holding_your_object;

import java.util.*;
import java.util.Collection;

class Question4 {
    int key = 0;
    public String next() {
        switch(key) {
            default:
            case 0 : key++; return "Snow White";
            case 1 : key++; return "Bashful";
            case 2 : key++; return "The hitman bodyguard wife";
            case 3 : key++; return "ivy";
            case 4 : key++; return "Think like a man";
            case 5 : key++; return "Happy";
            case 6 : key++; return "Sleepy";
            case 7 : key = 0; return "Sneezy";
        }
    }
    public void fillA(String[] a) {
        for(int i = 0; i < a.length; i++)
            a[i] = next();
    }
    public Collection fill(Collection<String> c, int n) {
        for(int i = 0; i < n; i++) c.add(next());
        return c;
    }
}

public class Generator {
    public static void main(String[] args) {
        Question4 question1 = new Question4();
        String[] a = new String[10];
        question1.fillA(a);
        for(String s : a) System.out.print(s + ", ");
        System.out.println();
        System.out.println(question1.fill(new ArrayList<>(), 10));
        System.out.println(question1.fill(new LinkedList<>(), 10));
        System.out.println(question1.fill(new HashSet<>(), 10));
        System.out.println(question1.fill(new LinkedHashSet<>(), 10));
        System.out.println(question1.fill(new TreeSet<>(), 10));
    }
}