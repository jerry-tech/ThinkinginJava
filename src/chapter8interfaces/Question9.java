package chapter8interfaces;

import chapter7Polymorphism.Note;

//Exercise 9: (3) Refactor Musics.java by moving the common methods in Wind,
//        Percussion and Stringed into an abstract class.

abstract class Instrument {
    private int i;
    public abstract void play(Note n);
    public String toString() { return "Instrument"; }
    public abstract void adjust();
}

class Wind extends Instrument {
    public void play(Note n) {
        System.out.print(this + ".play() " + n);
    }
    public String toString() { return "Wind"; }
    public void adjust() { System.out.print(this + ".adjust()"); }
}

class Percussion extends Instrument {
    public void play(Note n) {
        System.out.print(this + ".play() " + n);
    }
    public String toString() { return "Percussion"; }
    public void adjust() { System.out.print(this + ".adjust()"); }
}

class Stringed extends Instrument {
    public void play(Note n) {
        System.out.print(this + ".play() " + n);
    }
    public String toString() { return "Stringed"; }
    public void adjust() { System.out.print(this + ".adjust()"); }
}

class Brass extends Wind {
    public String toString() { return "Brass"; }
}

class Woodwind extends Wind {
    public String toString() { return "Woodwing"; }
}

public class Question9 {
    // Doesn't care about type, so new types
    // added to the system will work right:
    static void tune(Instrument i) {
        //...
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrument[] e) {
        for(Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}