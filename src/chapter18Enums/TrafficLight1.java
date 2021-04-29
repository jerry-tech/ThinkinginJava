package chapter18Enums;


import static chapter18Enums.Signal.*;

//Exercise 1: (2) Use a static import to modify TrafficLight.java so you don’t have to
//        qualify the enum instances.

public class TrafficLight1 {
    Signal color = RED;

    public void change() {
        switch (color) {
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }

    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight1 t = new TrafficLight1();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
