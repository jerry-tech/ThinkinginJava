package chapter8interfaces;


import interfaceCreation.Question6chap8;

public class Question6 implements Question6chap8 {

    public static void main(String[] args) {
        Question6 x = new Question6();
        x.oneMeth();
        x.twoMeth();
        x.threeMeth();
    }

    @Override
    public void oneMeth() {
        System.out.println("one");
    }

    @Override
    public void twoMeth() {
        System.out.println("two");
    }

    @Override
    public void threeMeth() {
        System.out.println("three");
    }
}