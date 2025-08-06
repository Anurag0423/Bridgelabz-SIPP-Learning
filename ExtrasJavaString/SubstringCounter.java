import java.util.Scanner;

public class SubstringCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mainString = getInput(scanner, "Enter the main string: ");
        String subString = getInput(scanner, "Enter the substring to count: ");

        int count = countOccurrences(mainString, subString);

        displayResult(mainString, subString, count);

        scanner.close();
    }

    // Function to get input strings
    public static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Function to count occurrences of substring
    public static int countOccurrences(String main, String sub) {
        int count = 0;
        int index = 0;

        while ((index = main.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length(); // move past the found substring
        }

        return count;
    }

    // Function to display result
    public static void displayResult(String main, String sub, int count) {
        System.out.println("The substring \"" + sub + "\" occurs " + count + " time(s) in the string.");
    }
}
