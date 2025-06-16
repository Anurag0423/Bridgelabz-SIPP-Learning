import java.util.Scanner;

public class RocketCountdownWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the starting number for countdown: ");
        int counter = sc.nextInt();

        System.out.println("\nStarting countdown...");
        while (counter >= 1) {
            System.out.println(counter);
            counter--; // Decrement counter
        }

        System.out.println("Liftoff!");

        sc.close();
    }
}
