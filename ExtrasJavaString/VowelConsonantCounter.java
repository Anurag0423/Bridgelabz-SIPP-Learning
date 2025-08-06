import java.util.Scanner;

public class VowelConsonantCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = getInput(scanner);
        int[] counts = countVowelsAndConsonants(input);

        displayCounts(counts[0], counts[1]);

        scanner.close();
    }

    // Function to get input string
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    // Function to count vowels and consonants
    public static int[] countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        return new int[]{vowels, consonants};
    }

    // Function to display counts
    public static void displayCounts(int vowels, int consonants) {
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
