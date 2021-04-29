package chapter11Error_handling_with_exceptions;

//Exercise 5: (3) Create your own resumption-like behavior using a while loop that
//        repeats until an exception is no longer thrown.
public class Question5 {
    private static int[] ia = new int[2];
    static int x = 5;
    public static void main(String[] args) {
        while(true) {
            try {
                ia[x] = 1;
                System.out.println(ia[x]);
                break;
            } catch(ArrayIndexOutOfBoundsException e) {
                System.err.println(
                        "Caught ArrayIndexOutOfBoundsException");
                e.printStackTrace();
                x--;
            } finally {
                System.out.println("Are we done yet?");
            }
        }
        System.out.println("Now, we're done.");
    }
}
