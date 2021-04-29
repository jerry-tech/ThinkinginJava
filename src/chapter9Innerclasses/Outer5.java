package chapter9Innerclasses;

//Exercise 5: (1) Create a class with an inner class. In a separate class, make an instance of
//        the inner class.

class outer {
    class Inner {
        Inner() { System.out.println("Outer.Inner()"); }
    }
}


public class Outer5 {
    public static void main(String[] args) {
        // must first create outer class object:
        outer o = new outer();
        // then create inner class object:
        outer.Inner oi = o.new Inner();
    }
}