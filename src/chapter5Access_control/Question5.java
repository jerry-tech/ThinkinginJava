package chapter5Access_control;


import chapter5.PackagedClass;

public class Question5 {

    public static void main(String[] args) {
        /**
         * Exercise 1:  (1) Create a class in a package. Create an instance of your class outside of that package.
         *
         *      @see PackagedClass
         */
        PackagedClass packagedClass = new PackagedClass();

        /**
         * Exercise 2:  (1) Take the code fragments in this section and turn them into a program, and verify that
         *      collisions do in fact occur.
         *
         *    @see chapter5.Debug
         *      @see Debug
         */

        /**
         * Exercise 3:  (2) Create two packages: debug and debugoff, containing an identical class with a debug( )
         *      method. The first version displays its String argument to the console, the second does nothing. Use a
         *      static import line to import the class into a test program, and demonstrate the conditional compilation
         *      effect.
         *
         *      @see chapter5.Debug
         *      @see Debug
         */
        Debug.debug("string");

        /**
         * Exercise 4:  (2) Show that protected methods have package access but are not public.
         *
         *      @see CookieThief
         *      @see
         */

        /**
         * Exercise 5:  (2) Create a class with public, private, protected, and package-access fields and method
         *      members. Create an object of this class and see what kind of compiler messages you get when you try to
         *      access all the class members. Be aware that classes in the same directory are part of the default
         *      package.
         *
         *      @see Access
         *      @see AccessOutside
         */

        Access access = new Access();
        System.out.println(access.a);
        System.out.println(access.b);
        System.out.println(access.c);



        /**
         * Exercise 6:  (1) Create a class with protected data. Create a second class in the same file with a method that
         *      manipulates the protected data in the first class.
         *
         *      @see ProtectedData
         *
         */

        /**
         * Exercise 7:  (1) Create the library according to the code fragments describing access and Widget. Create
         *      a Widget in a class that is not part of the access package.
         *
         *      @see Widget
         */
        Widget widget = new Widget();

        /**
         * Exercise 8:  (4) Following the form of the example Lunch.java, create a class called ConnectionManager that
         *      manages a fixed array of Connection objects. The client programmer must not be able to explicitly
         *      create Connection objects, but can only get them via a static method in ConnectionManager. When the
         *      ConnectionManager runs out of objects, it returns a null reference. Test the classes in main( ).
         *
         *      @see ConnectionManager
         *      @see Connection
         */
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());
        System.out.println(ConnectionManager.getConnection());


    }
}

