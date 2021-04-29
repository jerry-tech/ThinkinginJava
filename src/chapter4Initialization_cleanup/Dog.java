package chapter4Initialization_cleanup;

class DogTalk {
    void bark() {
        System.out.println("quiet");
    }

    void bark(char c) {
        System.out.println("rgrgrt4tt");
    }

    void bark(byte b) {
        System.out.println("rt4eet4t");
    }

    void bark(short s) {
        System.out.println("34545");
    }

    void bark(int i) {
        System.out.println("44455tyr");
    }

    void bark(long L) {
        System.out.println("etetet");
    }

    void bark(float f) {
        System.out.println("Juventus");
    }

    void bark(double d) {
        System.out.println("Real");
    }

    void bark(char c, int i) {
        System.out.println("inter");
    }

    void bark(int i, char c) {
        System.out.println("celtic fc");
    }
}


public class Dog {
    public static void main(String[] args) {
        DogTalk d = new DogTalk();
        char c = 'j';
        byte b = 0;
        short s = 0;
        d.bark();
        d.bark((char) c);
        d.bark((byte) b);
        d.bark((short) s);
        d.bark(1);
        d.bark(1L);
        d.bark(1.0f);
        d.bark(1.0);
        d.bark(c, 1);
        d.bark(1, c);
    }
}
