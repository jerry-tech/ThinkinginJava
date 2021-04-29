package chapter14Generics;

//Exercise 9: (1) Modify GenericMethods.java so that f( ) accepts three arguments, all
//        of which are of a different parameterized type.

public class GenericMethods9 {
    public <T, U, V> void f(T x, U y, V z) {
        System.out.println(x.getClass().getName() +
                " " + y.getClass().getName() +
                " " + z.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethods9 gm = new GenericMethods9();
        gm.f("", 1, 1.0);
        gm.f(1.0F, 'c', gm);
    }
}
