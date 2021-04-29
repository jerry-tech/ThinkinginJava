package chapter9Innerclasses;

//Exercise 6: (2) Create an interface with at least one method, in its own package. Create a
//class in a separate package. Add a protected inner class that implements the interface. In a
//        third package, inherit from your class and, inside a method, return an object of the
//protected inner class, upcasting to the interface during the return.


import classcreation.chap9BaseCla;
import interfaceCreation.Question6chap9;

public class Question6 extends chap9BaseCla {
    Question6chap9 getBaseInner() {
        return this.new Ex6BaseInner();
    }
    public static void main(String[] args) {
        Question6 ex = new Question6();
        System.out.println(ex.getBaseInner().say());
    }
}