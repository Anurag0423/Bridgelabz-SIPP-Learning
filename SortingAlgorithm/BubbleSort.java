import java.util.Scanner;

public class StudentMarksSorter {

    // Bubble Sort method
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap if needed
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped, the array is sorted
            if (!swapped) break;
        }
    }

    // Method to display the array
    public static void displayMarks(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] marks = new int[n];

        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            marks[i] = scanner.nextInt();
        }

        System.out.println("Original Marks:");
        displayMarks(marks);

        bubbleSort(marks);

        System.out.println("Sorted Marks (Ascending Order):");
        displayMarks(marks);

        scanner.close();
    }
}
