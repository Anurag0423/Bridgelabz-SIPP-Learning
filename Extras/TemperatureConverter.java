import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = getConversionChoice(scanner);
        double inputTemp = getTemperature(scanner);

        if (choice == 1) {
            double result = celsiusToFahrenheit(inputTemp);
            displayResult(inputTemp, result, "Celsius", "Fahrenheit");
        } else if (choice == 2) {
            double result = fahrenheitToCelsius(inputTemp);
            displayResult(inputTemp, result, "Fahrenheit", "Celsius");
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    // Function to choose conversion type
    public static int getConversionChoice(Scanner scanner) {
        System.out.println("Choose conversion type:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter choice (1 or 2): ");
        return scanner.nextInt();
    }

    // Function to get temperature input
    public static double getTemperature(Scanner scanner) {
        System.out.print("Enter temperature value: ");
        return scanner.nextDouble();
    }

    // Conversion functions
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Function to display result
    public static void displayResult(double input, double output, String from, String to) {
        System.out.printf("%.2f %s = %.2f %s%n", input, from, output, to);
    }
}
