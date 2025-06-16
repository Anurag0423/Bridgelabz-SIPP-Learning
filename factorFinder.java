import java.util.Scanner;

public class FactorsFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input. Please enter a number greater than 0.");
            return;
        }

        int counter = 1;

        System.out.println("Factors of " + number + " (excluding itself) are:");

        while (counter < number) {
            if (number % counter == 0) {
                // If counter perfectly divides number, print it
                System.out.println(counter);
            }
            counter++;
        }

        scanner.close();
    }
}
