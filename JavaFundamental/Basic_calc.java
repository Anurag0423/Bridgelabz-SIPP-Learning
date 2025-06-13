import java.util.*;
import java.util.Scanner;
class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();
        double sum = number1 + number2;
        double difference = number1 - number2;
        double product = number1 * number2;
        double quotient = number2 != 0 ? number1 / number2 : Double.NaN;
        System.out.printf(
            "The addition, subtraction, multiplication, and division value of 2 numbers %.2f and %.2f is:\n%.2f, %.2f, %.2f, and %.2f\n",
            number1, number2, sum, difference, product, quotient
        );

        input.close();
    }
}
