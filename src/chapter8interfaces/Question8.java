package chapter8interfaces;

//Exercise 8: (2) In polymorphism.Sandwich.java, create an interface called
//FastFoo d (with appropriate methods) and change Sandwic h so that it also implements
//        FastFood

interface FastFood {
    void cheeseburger();
    void fries();
    void softDrink();
}

class Meal {
    Meal() { System.out.print("Meal()"); }
}

class Bread {
    Bread() { System.out.print("Bread()"); }
}

class Cheese {
    Cheese() { System.out.print("Cheese()"); }
}

class Lettuce {
    Lettuce() { System.out.print("Lettuce()"); }
}

class Lunch extends Meal {
    Lunch() { System.out.print("Lunch()"); }
}

class PortableLunch extends Lunch {
    PortableLunch() { System.out.print("PortableLunch()"); }
}

public class Question8 extends PortableLunch implements FastFood {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lunch l = new Lunch();
    public Question8() { System.out.print("Sandwich8()"); }
    public void cheeseburger() {
        System.out.print("Cheeseburger");
    }
    public void fries() {
        System.out.print("Fries");
    }
    public void softDrink(){
        System.out.print("Soft Drink");
    }
    public static void main(String[] args) {
        Question8 s = new Question8();
        s.cheeseburger();
        s.fries();
        s.softDrink();

    }
}
