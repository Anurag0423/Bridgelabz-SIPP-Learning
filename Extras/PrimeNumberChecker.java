import java.util.Scanner;

public class PrimeNumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = getInput(scanner);
        boolean isPrime = checkPrime(number);
        displayResult(number, isPrime);

        scanner.close();
    }

    // Function to get input from user
    public static int getInput(Scanner scanner) {
        System.out.print("Enter a number to check if it's prime: ");
        return scanner.nextInt();
    }

    // Function to check if a number is prime
    public static boolean checkPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Function to display result
    public static void displayResult(int num, boolean isPrime) {
        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
