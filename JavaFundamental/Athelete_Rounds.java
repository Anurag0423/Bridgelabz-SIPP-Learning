import java.util.*;
import java.util.Scanner;
class AthleteRounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side 1 of the triangle (in meters): ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 of the triangle (in meters): ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 of the triangle (in meters): ");
        double side3 = input.nextDouble();
        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000;
        double rounds = totalDistance / perimeter;
        System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5 km\n", rounds);

        input.close();
    }
}





