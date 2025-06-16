import java.util.Scanner;

class SumUntilNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        System.out.println("Enter positive numbers to add (enter 0 or negative number to stop):");

        while (true) {
            System.out.print("Enter a number: ");
            int number = sc.nextInt();

            if (number <= 0) {
                break;
            }

            sum += number;
        }

        System.out.println("Total sum of all entered positive numbers is: " + sum);

        sc.close();
    }
}
