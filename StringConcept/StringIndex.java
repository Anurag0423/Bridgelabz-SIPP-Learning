import java.util.Scanner;

class StringIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        handleException(text);
    }

    public static void generateException(String str) {
        char ch = str.charAt(100);
        System.out.println("Character: " + ch);
    }

    public static void handleException(String str) {
        try {
            char ch = str.charAt(100);
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
