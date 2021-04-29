package chapter9Innerclasses;

//Exercise 10: (1) Repeat the previous exercise but define the inner class within a scope
//        within a method.


interface Qu10Interface {
    void say(String s);
}

public class Question10 {
    Qu10Interface f(boolean b) {
        if(b) {
            class Inner implements Qu10Interface {
                public void say(String s) {
                    System.out.println(s);
                }
            }
            return new Inner();
        }
        return null;
    }
    public static void main(String[] args) {
        Question10 x = new Question10();
        x.f(true).say("hi");
    }
}