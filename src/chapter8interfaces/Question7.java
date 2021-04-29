package chapter8interfaces;


interface Rodent1{
    String name = "Rodent";
    void eat();
    void run();
    void sleep();
    String toString();

}


class Mouse1 implements Rodent1 {
    private String name = "Mouse";
    public void eat() { System.out.println("Mouse.eat()"); }
    public void run() { System.out.println("Mouse.run()"); }
    public void sleep() { System.out.println("Mouse.sleep()"); }
    public String toString() { return name; }
}

class Rat1 implements Rodent1 {
    private String name = "Rat";
    public void eat() { System.out.println("Rat.eat()"); }
    public void run() { System.out.println("Rat.run()"); }
    public void sleep() { System.out.println("Rat.sleep()"); }
    public String toString() { return name; }
}

class Squirrel1 implements Rodent1 {
    private String name = "Squirrel";
    public void eat() { System.out.println("Squirrel.eat()"); }
    public void run() { System.out.println("Squirrel.run()"); }
    public void sleep() { System.out.println("Squirrel.sleep()"); }
    public String toString() { return name; }
}

public class Question7 {
    public static void main(String[] args) {
        Mouse1 pp = new Mouse1();
        pp.eat();
        pp.run();
        pp.sleep();
    }
}