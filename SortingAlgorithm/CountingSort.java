import java.util.Scanner;

public class StudentAgeSorter {

    // Counting Sort method for ages between 10 and 18
    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];       // To store frequency of each age
        int[] output = new int[ages.length]; // Sorted output

        // Step 1: Count frequencies
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build output array (stable sort)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Step 4: Copy sorted ages back to original array
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    // Display method
    public static void displayAges(int[] ages) {
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] ages = new int[n];

        System.out.println("Enter the ages of students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
            if (ages[i] < 10 || ages[i] > 18) {
                System.out.println("Invalid age entered. Please enter ages between 10 and 18.");
                return;
            }
        }

        System.out.println("Original Ages:");
        displayAges(ages);

        countingSort(ages);

        System.out.println("Sorted Ages (Ascending Order):");
        displayAges(ages);

        scanner.close();
    }
}
