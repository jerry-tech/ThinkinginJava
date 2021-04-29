package chapter1Everything_is_object;

public class StorageMeth {

    int storage(String s) {
        return s.length() * 2;
    }

    public static void main(String[] args) {
        new StorageMeth().storage("Nigeria");
    }
}
