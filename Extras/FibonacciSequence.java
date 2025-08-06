import java.util.Scanner;

public class FibonacciSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int terms = getInput(scanner);
        generateFibonacci(terms);

        scanner.close();
    }

    // Function to get the number of terms from user
    public static int getInput(Scanner scanner) {
        System.out.print("Enter the number of Fibonacci terms to generate: ");
        return scanner.nextInt();
    }

    // Function to generate and print Fibonacci sequence
    public static void generateFibonacci(int n) {
        int first = 0, second = 1;

        System.out.print("Fibonacci Sequence: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println(); // for newline
    }
}
