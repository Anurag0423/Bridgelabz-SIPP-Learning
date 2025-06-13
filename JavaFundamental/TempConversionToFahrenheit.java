import java.util.*;
import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = input.nextDouble();
        double fahrenheitResult = (celsius * 9 / 5) + 32;
        System.out.printf("The %.2f Celsius is %.2f Fahrenheit\n", celsius, fahrenheitResult);

        input.close();
    }
}


