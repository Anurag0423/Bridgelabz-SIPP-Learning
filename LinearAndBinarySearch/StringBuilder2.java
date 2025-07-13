import java.util.*;
import java.util.HashSet;

public class StringBuilder2 {
    public static void main(String[] args) {
        String input = "programming";

        // Step 1: Create a StringBuilder and a HashSet
        StringBuilder builder = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        // Step 2: Iterate over each character
        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                builder.append(c);   // Append if not a duplicate
                seen.add(c);         // Mark as seen
            }
        }

        // Step 3: Convert to String and print
        String result = builder.toString();
        System.out.println("String without duplicates: " + result);
    }
}
