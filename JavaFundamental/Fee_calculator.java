import java.util.Scanner;

public class FeeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the course fee (INR): ");
        double fee = scanner.nextDouble();
        System.out.print("Enter the university discount percentage: ");
        double discountPercent = scanner.nextDouble();
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f\n", discount, finalFee);

        scanner.close();
    }
}
