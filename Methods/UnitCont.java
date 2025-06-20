import java.util.*;
import java.util.Scanner;

class UnitConverter {

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        System.out.println("F to C: " + convertFahrenheitToCelsius(98.6));
        System.out.println("C to F: " + convertCelsiusToFahrenheit(37));
        System.out.println("Pounds to Kg: " + convertPoundsToKilograms(150));
        System.out.println("Kg to Pounds: " + convertKilogramsToPounds(68));
        System.out.println("Gallons to Liters: " + convertGallonsToLiters(5));
        System.out.println("Liters to Gallons: " + convertLitersToGallons(10));
    }
}
