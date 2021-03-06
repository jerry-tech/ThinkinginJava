package chapter5Access_control;

class SomeData {
    protected int a = 13;
}

class DataChanger {
    static void change(SomeData sd, int i) { sd.a = i; }
}

public class ProtectedData {
    public static void main(String[] args) {
        SomeData x = new SomeData();
        System.out.println(x.a);
        DataChanger.change(x, 99);
        System.out.println(x.a);
    }
}
