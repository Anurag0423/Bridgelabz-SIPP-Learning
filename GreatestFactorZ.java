import java.util.Scanner;

class GreatestFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number <= 1) {
            System.out.println("Please enter an integer greater than 1.");
            return;
        }

        int greatestFactor = 1; // Step 1: Initialize greatestFactor
        int counter = number - 1; // Step 2: Start counter from number - 1

        while (counter >= 1) {
            // Step 3: Check if counter is a factor of number
            if (number % counter == 0) {
                greatestFactor = counter;
                break; // Stop at the greatest factor found
            }
            counter--;
        }

        System.out.println("The greatest factor of " + number + " (excluding itself) is: " + greatestFactor);

        scanner.close();
    }
}
