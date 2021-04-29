package chapter8interfaces;

abstract class FirstDad {
}

class FirstSon extends FirstDad {
    protected void print() { System.out.print("Son"); }
}

abstract class SecondDad {
    abstract protected void print();
}

class SecondSon extends SecondDad {
    protected void print() { System.out.print("SecondSon"); }
}

public class Question4 {
    public static void testPrint(Dad d) {
        ((Son)d).print();
    }
    public static void secondTestPrint(SecondDad sd) {
        sd.print();
    }
    public static void main(String[] args) {
        Son s = new Son();
        Question4.testPrint(s);
        SecondSon ss = new SecondSon();
        Question4.secondTestPrint(ss);
    }
}