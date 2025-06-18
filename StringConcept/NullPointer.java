import java.util.*;

class NullPointerDemo {
    public static void main(String[] args) {
        handleException();
    }

    public static void generateException() {
        String text = null;
        int length = text.length();
        System.out.println("Length: " + length);
    }

    public static void handleException() {
        String text = null;
        try {
            int length = text.length();
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
