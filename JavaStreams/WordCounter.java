import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String fileName = "sample.txt"; // Replace with your text file
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Remove punctuation and split by spaces
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort by frequency in descending order
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            System.out.println("Top 5 Most Frequent Words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }
}
