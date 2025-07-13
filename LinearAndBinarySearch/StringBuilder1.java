import java.util.*;
public class StringBuilder1 {
    public static void main(String[] args) {
        String input = "hello";

        // Step 1: Create StringBuilder and append the input string
        StringBuilder builder = new StringBuilder();
        builder.append(input);

        // Step 2: Reverse the string
        builder.reverse();

        // Step 3: Convert back to String and print
        String reversed = builder.toString();
        System.out.println("Reversed string: " + reversed);
    }
}
