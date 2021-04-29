package chapter11Error_handling_with_exceptions;

public class Question2 {
    private static Integer i = null;
    public static void main(String[] args) {
        // leads to NullPointerException:
        // System.out.println(i.toString());
        try {
            System.out.println(i.toString());
        } catch(NullPointerException e) {
            System.err.println("Caught NullPointerException");
            e.printStackTrace();
        }
        try {
            i = 10;
            System.out.println(i.toString());
        } catch(NullPointerException e) {
            System.err.println("Caught NullPointerException");
            e.printStackTrace();
        } finally {
            System.out.println("Got through it");
        }
    }
}
