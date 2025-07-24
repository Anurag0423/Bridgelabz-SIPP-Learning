import java.util.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> freqMap = new HashMap<>();

        // Normalize text: lowercase + remove punctuation
        text = text.toLowerCase().replaceAll("[^a-z0-9\\s]", "");

        String[] words = text.split("\\s+");

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        return freqMap;
    }

    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        Map<String, Integer> frequencies = countWordFrequency(input);
        System.out.println("Word Frequencies: " + frequencies);
    }
}
