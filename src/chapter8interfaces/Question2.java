package chapter8interfaces;

abstract class abs1 {
    abs1() { System.out.println("abs1()"); }
}

abstract class ab2 {}

class Code extends abs1 {
    Code() { System.out.println("Code()"); }
}

public class Question2 {
    public static void main(String[] args) {

        Code g1 = new Code();
    }
}
