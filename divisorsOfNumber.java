import java.util.Scanner;

public class DivisorsOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive number less than 100: ");
        int number = scanner.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Invalid input. Please enter a number between 1 and 99.");
            return;
        }

        int counter = number - 1;

        while (counter > 1) {
            if (number % counter == 0) {
                System.out.println(counter + " is a divisor of " + number);
            }
            counter--;
        }

        scanner.close();
    }
}
