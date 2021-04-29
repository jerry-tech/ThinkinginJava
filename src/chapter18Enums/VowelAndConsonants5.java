package chapter18Enums;

import java.util.*;

//Exercise 5: (4) Modify control/VowelsAndConsonants.java so that it uses three
//enum types: VOWEL, SOMETIMES_A_VOWEL, and CONSONANT. The enum
//constructor should take the various letters that describe that particular category. Hint: Use
//        varargs, and remember that varargs automatically creates an array for you.

public enum VowelAndConsonants5 {
    VOWEL('a', 'e', 'i', 'o', 'u'),
    SOMETIMES_A_VOWEL('w', 'y'),
    CONSONANT('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
            'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z');
    private Character[] letters;
    private VowelAndConsonants5(Character... letters) {
        this.letters = letters;
    }
    public static VowelAndConsonants5 LetterType(Character c) {
        if(Arrays.asList(VOWEL.letters).contains(c)) return VOWEL;
        if(Arrays.asList(SOMETIMES_A_VOWEL.letters).contains(c))
            return SOMETIMES_A_VOWEL;
        return CONSONANT;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        for(int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';
            System.out.println((char)c + ", " + c + ": ");
            System.out.println(LetterType((char)c));
        }
    }
}