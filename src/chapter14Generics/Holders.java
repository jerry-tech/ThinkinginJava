package chapter14Generics;

//public class Holders<T> {
//    private T a;
//    public Holders(T a) { this.a = a; }
//    public void set(T a) { this.a = a; }
//    public T get() { return a; }
//    public static void main(String[] args) {
//        Holders<Pet> h3 =
//                new Holders<>(new Pet());
//        Pet a = h3.get(); // No cast needed
//        System.out.println(h3.get());
//        // can also hold a subclass of Pet:
//        h3.set(new Dog());
//        System.out.println(h3.get());
//        // can also hold a sububclass of Pet:
//        h3.set(new Gerbil());
//        System.out.println(h3.get());
//    }
//}