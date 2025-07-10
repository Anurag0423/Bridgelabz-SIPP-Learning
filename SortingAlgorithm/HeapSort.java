import java.util.Scanner;

public class SalarySorter {

    // Heap Sort method
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapify a subtree rooted at index i
    public static void heapify(int[] arr, int size, int i) {
        int largest = i;        // Initialize largest as root
        int left = 2 * i + 1;   // left child
        int right = 2 * i + 2;  // right child

        // If left child is larger than root
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, size, largest);
        }
    }

    // Display method
    public static void displayArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of job applicants: ");
        int n = scanner.nextInt();

        int[] salaries = new int[n];

        System.out.println("Enter the expected salaries:");
        for (int i = 0; i < n; i++) {
            salaries[i] = scanner.nextInt();
        }

        System.out.println("Original Salary Demands:");
        displayArray(salaries);

        heapSort(salaries);

        System.out.println("Sorted Salary Demands (Ascending Order):");
        displayArray(salaries);

        scanner.close();
    }
}
