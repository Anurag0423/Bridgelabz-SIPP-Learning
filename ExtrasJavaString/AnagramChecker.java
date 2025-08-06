import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = getInput(scanner, "Enter first string: ");
        String str2 = getInput(scanner, "Enter second string: ");

        boolean result = areAnagrams(str1, str2);

        if (result) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }

        scanner.close();
    }

    // Function to get input
    public static String getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine().replaceAll("\\s+", "").toLowerCase(); // ignore case and spaces
    }

    // Function to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
