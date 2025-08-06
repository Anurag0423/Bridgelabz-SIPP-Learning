import java.util.Scanner;

public class PalindromeString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = getInput(scanner);
        boolean isPalindrome = checkPalindrome(input);

        displayResult(input, isPalindrome);

        scanner.close();
    }

    // Function to get input string
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a string to check for palindrome: ");
        return scanner.nextLine().replaceAll("\\s+", "").toLowerCase(); // normalize
    }

    // Function to check if the string is a palindrome
    public static boolean checkPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Function to display result
    public static void displayResult(String input, boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is not a palindrome.");
        }
    }
}
