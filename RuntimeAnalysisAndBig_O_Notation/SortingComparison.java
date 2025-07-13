import java.util.Arrays;
import java.util.Random;
//2. Problem Statement: Sorting Large Data Efficiently
public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000}; // Avoid 1,000,000 for Bubble Sort due to time
        for (int size : sizes) {
            int[] original = generateRandomArray(size);

            // Bubble Sort (copy to avoid modifying original)
            int[] bubbleArray = Arrays.copyOf(original, original.length);
            long startBubble = System.nanoTime();
            bubbleSort(bubbleArray);
            long endBubble = System.nanoTime();
            System.out.println("\nBubble Sort - Size " + size + ": " + (endBubble - startBubble) / 1_000_000.0 + " ms");

            // Merge Sort
            int[] mergeArray = Arrays.copyOf(original, original.length);
            long startMerge = System.nanoTime();
            mergeSort(mergeArray, 0, mergeArray.length - 1);
            long endMerge = System.nanoTime();
            System.out.println("Merge Sort - Size " + size + ": " + (endMerge - startMerge) / 1_000_000.0 + " ms");

            // Quick Sort
            int[] quickArray = Arrays.copyOf(original, original.length);
            long startQuick = System.nanoTime();
            quickSort(quickArray, 0, quickArray.length - 1);
            long endQuick = System.nanoTime();
            System.out.println("Quick Sort - Size " + size + ": " + (endQuick - startQuick) / 1_000_000.0 + " ms");
        }
    }

    // Bubble Sort (O(N²))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization
        }
    }

    // Merge Sort (O(N log N))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    // Quick Sort (O(N log N))
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1; // Index of smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap pivot
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Utility: Generate random array
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size * 10);
        return arr;
    }
}
