import java.util.Scanner;

public class ToggleCase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = getInput(scanner);
        String toggled = toggleCase(input);

        displayResult(input, toggled);

        scanner.close();
    }

    // Function to get input string
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    // Function to toggle case
    public static String toggleCase(String str) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(ch); // keep digits/symbols unchanged
            }
        }

        return result.toString();
    }

    // Function to display result
    public static void displayResult(String original, String toggled) {
        System.out.println("Original String: " + original);
        System.out.println("Toggled Case String: " + toggled);
    }
}
