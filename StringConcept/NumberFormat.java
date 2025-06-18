import java.util.Scanner;

class NumberFormatDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        handleException(text);
    }

    public static void generateException(String str) {
        int number = Integer.parseInt(str);
        System.out.println("Number: " + number);
    }

    public static void handleException(String str) {
        try {
            int number = Integer.parseInt(str);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
