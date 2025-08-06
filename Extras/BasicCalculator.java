import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = getNumber(scanner, "Enter first number: ");
        double num2 = getNumber(scanner, "Enter second number: ");
        char operation = getOperation(scanner);

        double result = performOperation(num1, num2, operation);
        displayResult(num1, num2, operation, result);

        scanner.close();
    }

    // Function to get a number from user
    public static double getNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    // Function to get desired operation
    public static char getOperation(Scanner scanner) {
        System.out.print("Choose operation (+, -, *, /): ");
        return scanner.next().charAt(0);
    }

    // Function to perform the chosen operation
    public static double performOperation(double a, double b, char op) {
        switch (op) {
            case '+': return add(a, b);
            case '-': return subtract(a, b);
            case '*': return multiply(a, b);
            case '/': return divide(a, b);
            default:
                System.out.println("Invalid operation.");
                return Double.NaN;
        }
    }

    // Arithmetic operation functions
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero.");
            return Double.NaN;
        }
        return a / b;
    }

    // Function to display result
    public static void displayResult(double a, double b, char op, double result) {
        if (!Double.isNaN(result)) {
            System.out.printf("%.2f %c %.2f = %.2f%n", a, op, b, result);
        } else {
            System.out.println("Calculation could not be completed.");
        }
    }
}
