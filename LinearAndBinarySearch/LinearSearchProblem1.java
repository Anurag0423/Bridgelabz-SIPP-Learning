import java.util.*;
//FirstNegativeSearch
public class LinearSearchProblem2 {
    public static void main(String[] args) {
        int[] numbers = {5, 10, 3, 0, -4, 7, -1};  // Sample array
        int index = findFirstNegative(numbers);

        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }

    // Method to perform linear search for the first negative number
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;  // Found first negative number
            }
        }
        return -1;  // No negative number found
    }
}
