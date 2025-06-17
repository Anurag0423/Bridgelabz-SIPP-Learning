import java.util.Scanner;

class StoreAndSum {
    public static void main(String[] args) {
        // Step 1: Declare array and helper variables
        double[] numbers = new double[10]; 
        double total = 0.0;
        int index = 0; 

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter up to 10 numbers (0 or any negative number to stop):");
        while (true) {
            double value = sc.nextDouble();
            if (value <= 0) {
                break;
            }

            if (index == 10) {
                System.out.println("Maximum of 10 numbers reached.");
                break;
            }

            numbers[index] = value;
            index++;
        }

        sc.close();
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }
        System.out.print("\nNumbers entered: ");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\nSum of all numbers = " + total);
    }
}
