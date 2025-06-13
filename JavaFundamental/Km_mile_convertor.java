import java.util.Scanner;

public class KmToMilesConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double km;
        System.out.print("Enter the distance in kilometers: ");
        km = input.nextDouble();
        double miles = km / 1.6;

        System.out.printf("The total miles is %.2f mile for the given %.2f km\n", miles, km);

        input.close();
    }
}

