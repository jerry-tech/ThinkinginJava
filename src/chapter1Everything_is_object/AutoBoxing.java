package chapter1Everything_is_object;

public class AutoBoxing {
    public static void main(String[] args) {
        /**
         * Exercise 9:  (2) Write a program that demonstrates that autoboxing works for all the primitive types and
         *      their wrappers.
         */

        int i = 3;
        Integer I;
        I = i;
        System.out.println(I);

        boolean b = true;
        Boolean B;
        B = b;
        System.out.println(B);

        char ch = 'x';
        Character Ch;
        Ch = ch;
        System.out.println(Ch);

        byte by = 3;
        Byte By;
        By = by;
        System.out.println(By);

        short sh = 4;
        Short Sh;
        Sh = sh;
        System.out.println(Sh);

        long l = 43;
        Long L;
        L = l;
        System.out.println(L);

        float f = (float) 5.1;
        Float F;
        F = f;
        System.out.println(F);

        double d = 3.9;
        Double D;
        D = d;
        System.out.println(D);
    }
}
