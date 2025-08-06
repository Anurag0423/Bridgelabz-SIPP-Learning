import java.util.*;
import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter index to access: ");
        int index = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        try {
            // Outer try block handles ArrayIndexOutOfBoundsException
            try {
                int value = arr[index];  // May throw ArrayIndexOutOfBoundsException
                int result = value / divisor; // May throw ArithmeticException
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}
