import java.util.Scanner;

class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0.0;
        double number;

        System.out.println("Enter numbers to sum (enter 0 to stop):");

        System.out.print("Enter a number: ");
        number = sc.nextDouble();

        while (number != 0) {
            total += number;

            System.out.print("Enter a number: ");
            number = sc.nextDouble();
        }
        System.out.println("The total sum is: " + total);

        sc.close();
    }
}
