package chapter11Error_handling_with_exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

//Exercise 7: (1) Modify Exercise 3 so that the catch clause logs the results.
//\
public class Question7 {
    private static int[] ia = new int[2];
    private static Logger logger = Logger.getLogger("Ex7 Exceptions");
    static void logException(Exception e) { // Exception e argument
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String[] args) {
        try {
            ia[2] = 3;
        } catch(ArrayIndexOutOfBoundsException e) {
            System.err.println(
                    "Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
            // call logging method:
            logException(e);
        }
    }
}
