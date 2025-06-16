import java.util.Scanner;

class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        int number = scanner.nextInt();

        int count = 0;

        if (number == 0) {
            count = 1;
        } else {
            // Step 3-5: Use loop to count digits
            while (number != 0) {
                number = number / 10;  
                count++;              
            }
        }
        System.out.println("Number of digits: " + count);

        scanner.close();
    }
}
