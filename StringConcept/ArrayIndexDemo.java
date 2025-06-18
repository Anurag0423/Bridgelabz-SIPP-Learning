import java.util.Scanner;

class ArrayIndexDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[3];
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.next();
        }

        generateException(names);
        handleException(names);
    }

    public static void generateException(String[] arr) {
        String name = arr[5];
        System.out.println("Accessed name: " + name);
    }

    public static void handleException(String[] arr) {
        try {
            String name = arr[5];
            System.out.println("Accessed name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}
