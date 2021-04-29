package chapter9Innerclasses;

//Exercise 4: (2) Add a method to the class Sequence.SequenceSelector that produces
//        the reference to the outer class Sequence.

interface Selector4 {
    boolean end();
    Object current();
    void next();
}

public class Sequence4 {
    private Object[] items;
    private int next = 0;
    // to test SequenceSelector sequence4() in main():
    public void test() { System.out.println("Sequence4.test()"); }
    public Sequence4(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }
    private class SequenceSelector4 implements Selector4 {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
        // method to produce outer class reference:
        public Sequence4 sequence4() { return Sequence4.this; }
    }
    public Selector4 selector() {
        return new SequenceSelector4();
    }
    public static void main(String[] args) {
        Sequence4 sequence = new Sequence4(10);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector4 selector4 = sequence.selector();
        while(!selector4.end()) {
            System.out.print(selector4.current() + " ");
            selector4.next();
        }
        // cast and test:
        ((SequenceSelector4) selector4).sequence4().test();
    }
}
