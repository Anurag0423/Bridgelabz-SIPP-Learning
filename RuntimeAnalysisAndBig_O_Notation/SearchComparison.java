import java.util.Arrays;
import java.util.Random;
//1. Problem Statement: Search a Target in a Large Dataset
public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        int target = -1; // Choose a target not present to simulate worst-case

        for (int size : sizes) {
            int[] data = generateRandomArray(size);

            // Linear Search
            long startLinear = System.nanoTime();
            int resultLinear = linearSearch(data, target);
            long endLinear = System.nanoTime();

            // Binary Search (after sorting)
            Arrays.sort(data); // O(N log N)
            long startBinary = System.nanoTime();
            int resultBinary = Arrays.binarySearch(data, target); // O(log N)
            long endBinary = System.nanoTime();

            // Output Results
            System.out.println("\nDataset Size: " + size);
            System.out.println("Linear Search Time: " + (endLinear - startLinear) / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + (endBinary - startBinary) / 1_000_000.0 + " ms");
        }
    }

    // Linear Search implementation
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // Generate random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 2); // To reduce duplicates
        }
        return arr;
    }
}
