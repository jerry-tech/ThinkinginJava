package chapter9Innerclasses;

//Exercise 3: (1) Modify Exercise 1 so that Outer has a private String field (initialized
//        by the constructor), and Inner has a toString( ) that displays this field. Create an object of
//        type Inner and display it.

public class Outer2 {
    private String s;
    class Inner2 {
        Inner2() { System.out.println("Inner()"); }
        public String toString() { return s; }
    }
    Outer2(String s) {
        System.out.println("Outer1()");
        this.s = s;
    }
    Inner2 makeInner2() {
        return new Inner2();
    }
    public static void main(String[] args) {
        Outer2 o = new Outer2("Ronaldo!");
        Inner2 i = o.makeInner2();
        System.out.println(i.toString());
    }
}
