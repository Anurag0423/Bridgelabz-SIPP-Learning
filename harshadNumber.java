import java.util.Scanner;

class HarshadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int sum = 0;
        int originalNumber = number;

        while (number > 0) {
            int digit = number % 10; 
            sum += digit;           
            number = number / 10;    
        }
        if (originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad Number.");
        } else {
            System.out.println(originalNumber + " is Not a Harshad Number.");
        }

        scanner.close();
    }
}
