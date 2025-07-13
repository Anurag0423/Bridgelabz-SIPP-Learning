import java.util.*;
//SearchWordInSentences
public class LinearSearchProblem2 {
    public static void main(String[] args) {
        String[] sentences = {
            "Java is a powerful language.",
            "Python is great for data science.",
            "JavaScript runs in the browser.",
            "C++ is used for system programming."
        };

        String wordToFind = "Python"; // 🔁 Change this word to test

        String result = findSentenceContainingWord(sentences, wordToFind);
        System.out.println("Result: " + result);
    }

    // Method to perform linear search for the word in the array of sentences
    public static String findSentenceContainingWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) { // Case-sensitive match
                return sentence;
            }
        }
        return "Not Found";
    }
}
