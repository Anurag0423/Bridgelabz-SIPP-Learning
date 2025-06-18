import java.util.Scanner;

class IllegalArgumentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        handleException(text);
    }

    public static void generateException(String str) {
        String sub = str.substring(5, 2);
        System.out.println("Substring: " + sub);
    }

    public static void handleException(String str) {
        try {
            String sub = str.substring(5, 2);
            System.out.println("Substring: " + sub);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
