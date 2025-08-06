import java.util.Scanner;

public class StringReverser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = getInput(scanner);
        String reversed = reverseString(input);

        displayResult(input, reversed);

        scanner.close();
    }

    // Function to get input string
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a string to reverse: ");
        return scanner.nextLine();
    }

    // Function to reverse the string manually
    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i); // or use StringBuilder for better performance
        }
        return reversed;
    }

    // Function to display result
    public static void displayResult(String original, String reversed) {
        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);
    }
}
