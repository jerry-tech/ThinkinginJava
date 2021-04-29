package chapter6Reusing_classes;


import chapter6Reusing_classes.protectedpackage.AClass;

public class Question6 {
    /**
     * Exercise 18:    (2) Create a class with a static final field and a final field and demonstrate the
     *      difference between the two.
     *
     *      @see Question6
     */
    static final int ONE = 1;
    final int TWO = 2;


    public static void main(String[] args) {
        /**
         * Exercise 1:   (2) Create a simple class. Inside a second class, define a reference to an object of the first
         *      class. Use lazy initialization to instantiate this object.
         *
         *      @see SimpleClass
         *      @see LazyClass
         */
        SimpleClass simple = new SimpleClass();

        /**
         * Exercise 2:  (2) Inherit a new class from class Detergent. Override scrub( ) and add a new method called
         *      sterilize( ).
         *
         *      @see Tide
         *      @see Detergent
         *      @see Cleanser
         */
        Tide tide = new Tide();
        tide.dilute();
        tide.apply();
        tide.scrub();
        tide.foam();
        tide.sterilize();
        System.out.println(tide);

        /**
         * ...construction happens from the base 'outward,' so the base class is initialized before the derived-class
         *      constructors can access it. Even if you do not create a constructor for Cartoon( ), the compiler will
         *      synthesize a default constructor for you that calls the base-class constructor.
         *
         * Exercise 3:  (2) Prove the previous sentence.
         *
         *      @see Cartoon
         *      @see Drawing
         *      @see Art
         */
        Cartoon cartoon = new Cartoon();

        /**
         * Exercise 4:  (2) Prove that base-class constructors are (a) always called and (b) called before
         *      derived-class constructors.
         *
         *      @see Cartoon
         *      @see Drawing
         *      @see Art
         */

        /**
         * Exercise 5:  (1) Create two classes, A and B, with default constructors (empty argument lists) that announce
         *      themselves. Inherit a new class called C from A, and create a member of class B inside C. Do not create
         *      a constructor for C. Create an object of class C and observe the results.
         *
         *      @see A
         *      @see B
         *      @see C
         */
        C c = new C();

        /**
         * If you do not call the base-class constructor in BoardGame( ), the compiler will complain that it can not
         *      find a constructor of the form Game( ). In addition, the call to the base-class constructor must be the
         *      first thing you do in the derived-class constructor. (The compiler will remind you if you get it wrong.)
         *
         *      Exercise 6:  (1) Using Chess.java, prove the statements in the previous paragraph.
         *      @see Chess
         *      @see BoardGame
         *      @see Game
         */
        Chess chess = new Chess();

        /**
         * Exercise 7:  (1) Modify Exercise 5 so that A and B have constructors with arguments instead of default
         *      constructors. Write a constructor for C and perform all initialization within Cs constructor.
         *
         *      @see A
         *      @see B
         *      @see C
         */

        /**
         *  Exercise 8:  (1) Create a base class with only a non-default constructor, and a derived class with both a
         *      default (no-arg) and non-default constructor. In the derived-class constructors, call the
         *      base-class constructor.
         *
         *      @see MyBaseClass
         *      @see Derived
         */
        Derived derived = new Derived();

        /**
         * Exercise 9:  (2) Create a class called Root that contains an instance of each of the classes
         *      (that you also create) named Component1, Component2, and Component3. Derive a class Stem from Root that
         *      also contains an instance of each 'component.' All classes should have default constructors that print
         *      a message about that class.
         *
         *      @see Root
         *      @see Stem
         *      @see Component1
         *      @see Component2
         *      @see Component3
         */
        Stem stem = new Stem("Stem");

        /**
         * Exercise 10:    (1) Modify the previous exercise so that each class only has non-default constructors.
         *
         *      @see Root
         *      @see Stem
         *      @see Component1
         *      @see Component2
         *      @see Component3
         */

        /**
         * Exercise 11:    (3) Modify Detergent.java so that it uses delegation.
         *
         *      @see Detergent
         */

        /**
         * Exercise 12:    (3) Add a proper hierarchy of dispose( ) methods to all the classes in Exercise 9.
         *
         *      @see Root
         *      @see Stem
         */
        stem.dispose();


        /**
         * Exercise 13:    (2) Create a class with a method that is overloaded three times. Inherit a new class, add a
         *      new overloading of the method, and show that all four methods are available in the derived class.
         *
         *      @see OverLoaded
         *      @see InheritOverLoaded
         */
        OverLoaded overLoaded = new OverLoaded();
        InheritOverLoaded inheritOverLoaded = new InheritOverLoaded();
//        inheritOverLoaded

        /**
         * Exercise 14:    (1) In Car.java add a service( ) method to Engine and call this method in main( ).
         *
         *      @see Car
         *      @see Door
         *      @see Window
         *      @see Wheel
         *      @see Engine
         */
        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
        car.engine.changeOil();

        /**
        * Exercise 15:    (2) Create a class inside a package. Your class should contain a protected method. Outside of
        *       the package, try to call the protected method and explain the results. Now inherit from your class and
        *       call the protected method from inside a method of your derived class.
        *
        *       @see AClass
        *       @see AnotherClass
        */
        AClass aClass = new AClass();
        AnotherClass anotherClass = new AnotherClass();
        anotherClass.callProtectedMethod();

        /**
         * Exercise 16:    (2) Create a class called Amphibian. From this, inherit a class called Frog. Put appropriate
         *      methods in the base class. In main( ), create a Frog and upcast it to Amphibian, and demonstrate that
         *      all the methods still work.
         *
         *      @see Amphibian
         *      @see Frog
         */
        Amphibian amphibian = new Amphibian();
        Frog frog = new Frog();
        frog.print(frog);
        amphibian.print(frog);

        /**
         * Exercise 17:    (1) Modify Exercise 16 so that Frog overrides the method definitions from the base class
         *      (provides new definitions using the same method signatures). Note what happens in main( ).
         *
         *      @see Amphibian
         *      @see Frog
         */
        amphibian.method();
        frog.method();


        /**
         * Exercise 18:    (2) Create a class with a static final field and a final field and demonstrate the
         *      difference between the two.
         *
         *      @see Question6
         */
        Question6 question6 = new Question6();
        System.out.println(Question6.ONE);
        System.out.println(question6.TWO);

        /**
         * Exercise 19:    (2) Create a class with a blank final reference to an object. Perform the initialization of
         *      the blank final inside all constructors. Demonstrate the guarantee that the final must be initialized
         *      before use, and that it cannot be changed once initialized.
         *
         *      @see BlankFinal
         */
        BlankFinal blankFinal = new BlankFinal(frog);

//        Exercise 20:   (1) Show that the @Override annotation solves the problem in this section.
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can't call the methods:
        //! op.f();
        //! op.g();
        // Same here:
        WithFinals wf = op2;
        //! wf.f();
        //! wf.g();


        /**
         * Exercise 22:   (1) Create a final class and attempt to inherit from it.
         *
         *      @see FinalClass
         *      @see InheritClass
         */
        InheritClass inheritClass = new InheritClass();

    }
}

