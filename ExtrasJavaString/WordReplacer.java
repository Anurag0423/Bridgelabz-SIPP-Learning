import java.util.Scanner;

public class WordReplacer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentence = getInput(scanner, "Enter the sentence: ");
        String wordToReplace = getInput(scanner, "Enter the word to replace: ");
        String replacementWord = getInput(scanner, "Enter the replacement word: ");

        String modifiedSentence = replaceWord(sentence, wordToReplace, replacementWord);

        System.out.println("Modified Sentence: " + modifiedSentence);

        scanner.close();
    }

    // Function to get input
    public static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Function to replace word in sentence
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replaceAll("\\b" + oldWord + "\\b", newWord); // \b ensures full word match
    }
}
