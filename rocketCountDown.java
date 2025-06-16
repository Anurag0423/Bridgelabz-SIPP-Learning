import java.util.Scanner;

class RocketCountdown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the starting number for countdown: ");
        int counter = sc.nextInt();

        System.out.println("\nStarting countdown...");
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println("Liftoff!");

        sc.close();
    }
}
