package chapter11Error_handling_with_exceptions;

//Exercise 8: (1) Write a class with a method that throws an exception of the type created
//        in Exercise 4. Try compiling it without an exception specification to see what the compiler
//        says. Add the appropriate exception specification. Try out your class and its exception inside
//        a try-catch clause.

class Exception8 extends Exception {
    private String msg;
    Exception8(String msg) {
        super(msg);
        System.out.println("Exception4()");
        this.msg = msg;
    }
    protected void showS() {
        System.out.println("Message from Exception4: " + msg);
    }
}

class Test8 {
    public static void f() throws Exception4 {
        System.out.println("f()");
        throw new Exception4("Ouch from f()");
    }
}

public class Question8 {
    public static void main(String[] args) {
        try {
            Test8 t = new Test8();
            t.f();
        } catch(Exception4 e) {
            System.err.println("Caught Exception4");
            e.printStackTrace();
            e.showS();
        }
    }
}