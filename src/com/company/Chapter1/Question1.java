package com.company.Chapter1;

public class Question1 {

    int num1;
    char alpha;

    /** Create a class containing an int and a char that are not initialized, and
     * print their values to verify that Java performs default initialization.
     */
    Question1() {
        System.out.println(num1);

        System.out.println(alpha);
    }

    public static void main(String[] args) {
        new Question1();
    }
}
