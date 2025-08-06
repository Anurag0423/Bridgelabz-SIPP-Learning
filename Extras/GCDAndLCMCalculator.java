import java.util.Scanner;

public class GCDAndLCMCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = getInput(scanner, "Enter first number: ");
        int num2 = getInput(scanner, "Enter second number: ");

        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);

        displayResults(num1, num2, gcd, lcm);

        scanner.close();
    }

    // Function to get input
    public static int getInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    // Function to calculate GCD using Euclidean algorithm
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // Function to calculate LCM using formula: LCM = (a * b) / GCD
    public static int calculateLCM(int a, int b, int gcd) {
        return Math.abs(a * b) / gcd;
    }

    // Function to display results
    public static void displayResults(int a, int b, int gcd, int lcm) {
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }
}
