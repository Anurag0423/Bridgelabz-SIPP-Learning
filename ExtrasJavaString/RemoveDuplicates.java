import java.util.Scanner;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = getInput(scanner);
        String result = removeDuplicates(input);

        displayResult(input, result);

        scanner.close();
    }

    // Function to get input string
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    // Function to remove duplicates
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256]; // ASCII character set

        for (char ch : str.toCharArray()) {
            if (!seen[ch]) {
                seen[ch] = true;
                result.append(ch);
            }
        }

        return result.toString();
    }

    // Function to display result
    public static void displayResult(String original, String modified) {
        System.out.println("Original String: " + original);
        System.out.println("String after removing duplicates: " + modified);
    }
}
