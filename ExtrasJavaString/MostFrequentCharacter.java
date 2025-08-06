import java.util.Scanner;

public class MostFrequentCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = getInput(scanner);
        char result = findMostFrequentChar(input);

        System.out.println("Most Frequent Character: '" + result + "'");

        scanner.close();
    }

    // Function to get user input
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    // Function to find the most frequent character
    public static char findMostFrequentChar(String str) {
        int[] freq = new int[256]; // for ASCII characters

        for (char c : str.toCharArray()) {
            freq[c]++;
        }

        int max = 0;
        char mostFrequent = ' ';
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                mostFrequent = (char) i;
            }
        }

        return mostFrequent;
    }
}
