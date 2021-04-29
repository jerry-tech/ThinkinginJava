package chapter19concurrency;

//Exercise 8: (1) Modify MoreBasicThreads.java so that all the threads are daemon
//        threads, and verify that the program ends as soon as main( ) is able to exit.

class MoreBasicThreads8 {
    public MoreBasicThreads8() {
        try { // increase number of threads to see effect
            for(int i = 0; i < 25; i++) {
                Thread t = new Thread();
                t.setDaemon(true);
                t.start();
            }
            System.out.println("Waiting for LiftOff");

        } finally {
            System.out.println("Finally out of main");
        }
    }
}
public class Question8{

    public static void main(String[] args) {
        new MoreBasicThreads8();
    }

}
