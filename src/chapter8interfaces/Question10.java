package chapter8interfaces;

//Exercise 10: (3) Modify Musics.java by adding a Playable1 interface. Move the play( )
//        declaration from Instrument1 to Playable1. Add Playable1 to the derived classes by
//        including it in the implement s list. Change tune( ) so that it takes a Playable1 instead of
//        an Instrument1. 


import chapter7Polymorphism.Note;

interface Instrument1 {
    // Compile-time constant:
    int VALUE = 5; // static and final
    // Cannot have method definitions:	
    void adjust();
}

interface Playable1 {
    void play(Note n); // Automatically public
}

class Wind1 implements Instrument1, Playable1 {
    public void play(Note n) {
        System.out.print(this + ".play() " + n);
    }
    public String toString() { return "Wind"; }
    public void adjust() { System.out.print(this + ".adjust()"); }
}


class Percussion1 implements Instrument1, Playable1 {
    public void play(Note n) {
        System.out.print(this + ".play() " + n);
    }
    public String toString() { return "Percussion"; }
    public void adjust() { System.out.print(this + ".adjust()"); }
}

class Stringed1 implements Instrument1, Playable1 {
    public void play(Note n) {
        System.out.print(this + ".play() " + n);
    }
    public String toString() { return "Stringed"; }
    public void adjust() { System.out.print(this + ".adjust()"); }
}

class Brass1 extends Wind1 {
    public String toString() { return "Brass"; }
}

class Woodwind1 extends Wind1 {
    public String toString() { return "Woodwing"; }
}

public class Question10 {
    // Doesn't care about type, so new types
    // added to the system will work right:
    static void tune(Playable1 p) {
        //...
        p.play(Note.MIDDLE_C);
    }
    static void tuneAll(Playable1[] e) {
        for(Playable1 p : e)
            tune(p);
    }
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Playable1[] orchestra = {
                new Wind1(),
                new Percussion1(),
                new Stringed1(),
                new Brass1(),
                new Woodwind1()
        };
        tuneAll(orchestra);
    }
}
