import java.util.Scanner;

public class EmployeeIDSorter {

    // Insertion Sort method
    public static void insertionSort(int[] ids) {
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            // Move elements that are greater than key one position ahead
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j = j - 1;
            }

            ids[j + 1] = key;
        }
    }

    // Display method
    public static void displayIDs(int[] ids) {
        for (int id : ids) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();

        int[] ids = new int[n];

        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            ids[i] = scanner.nextInt();
        }

        System.out.println("Original Employee IDs:");
        displayIDs(ids);

        insertionSort(ids);

        System.out.println("Sorted Employee IDs (Ascending Order):");
        displayIDs(ids);

        scanner.close();
    }
}
