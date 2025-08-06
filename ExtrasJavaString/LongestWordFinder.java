import java.util.Scanner;

public class LongestWordFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentence = getInput(scanner);
        String longestWord = findLongestWord(sentence);

        displayResult(longestWord);

        scanner.close();
    }

    // Function to get input sentence
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        return scanner.nextLine();
    }

    // Function to find the longest word
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+");
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest;
    }

    // Function to display result
    public static void displayResult(String word) {
        System.out.println("Longest word: " + word);
    }
}
