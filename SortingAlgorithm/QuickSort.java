import java.util.Scanner;

public class ProductPriceSorter {

    // Quick Sort method
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);  // Get partition index

            // Recursively sort elements before and after partition
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    // Partition method
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];  // Choose last element as pivot
        int i = low - 1;  // Index of smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap pivot with element at i+1
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    // Display array
    public static void displayPrices(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = scanner.nextInt();

        double[] prices = new double[n];

        System.out.println("Enter the product prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }

        System.out.println("Original Product Prices:");
        displayPrices(prices);

        quickSort(prices, 0, n - 1);

        System.out.println("Sorted Product Prices (Ascending Order):");
        displayPrices(prices);

        scanner.close();
    }
}
