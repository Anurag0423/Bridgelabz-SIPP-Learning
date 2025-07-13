import java.util.*;

public class StringBufferProblem1 {
    public static void main(String[] args) {
        // Sample input array
        String[] words = {"Java", " ", "is", " ", "fast", " ", "and", " ", "powerful"};

        // Step 1: Create a new StringBuffer object
        StringBuffer buffer = new StringBuffer();

        // Step 2: Iterate through the array and append each string
        for (String word : words) {
            buffer.append(word);
        }

        // Step 3: Convert to String and print the result
        String result = buffer.toString();
        System.out.println("Concatenated String: " + result);
    }
}
