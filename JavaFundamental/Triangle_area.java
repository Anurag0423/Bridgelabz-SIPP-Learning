import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input for base and height in cm
        System.out.print("Enter the base of the triangle in cm: ");
        double base = input.nextDouble();

        System.out.print("Enter the height of the triangle in cm: ");
        double height = input.nextDouble();

        // Calculate area in square centimeters
        double areaCm = 0.5 * base * height;

        // Convert cm² to in² (1 inch = 2.54 cm → 1 in² = (2.54)^2 cm²)
        double areaIn = areaCm / (2.54 * 2.54);

        // Output
        System.out.printf("The Area of the triangle in sq in is %.2f and sq cm is %.2f\n", areaIn, areaCm);

        input.close();
    }
}
