import java.util.Scanner;

public class FactorialRecursive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = getInput(scanner);
        long result = calculateFactorial(number);
        displayResult(number, result);

        scanner.close();
    }

    // Function to get input
    public static int getInput(Scanner scanner) {
        System.out.print("Enter a number to find its factorial: ");
        return scanner.nextInt();
    }

    // Recursive function to calculate factorial
    public static long calculateFactorial(int n) {
        if (n <= 1)
            return 1;
        else
            return n * calculateFactorial(n - 1);
    }

    // Function to display result
    public static void displayResult(int num, long factorial) {
        System.out.println("Factorial of " + num + " is: " + factorial);
    }
}
