import java.util.Scanner;

public class LexicographicalCompare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = getInput(scanner, "Enter first string: ");
        String str2 = getInput(scanner, "Enter second string: ");

        compareStrings(str1, str2);

        scanner.close();
    }

    // Function to get input
    public static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Function to compare two strings
    public static void compareStrings(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());

        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) < s2.charAt(i)) {
                    System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
                } else {
                    System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\" in lexicographical order");
                }
                return;
            }
        }

        // If all characters so far are same, shorter one comes first
        if (s1.length() == s2.length()) {
            System.out.println("Both strings are equal.");
        } else if (s1.length() < s2.length()) {
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
        } else {
            System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\" in lexicographical order");
        }
    }
}
