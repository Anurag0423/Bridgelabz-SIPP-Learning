import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Think of a number between 1 and 100 and I will try to guess it!");

        int low = 1;
        int high = 100;
        boolean correct = false;

        while (!correct && low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Type: high / low / correct)");
            String feedback = getUserFeedback(scanner);

            switch (feedback) {
                case "high":
                    high = guess - 1;
                    break;
                case "low":
                    low = guess + 1;
                    break;
                case "correct":
                    System.out.println("Yay! I guessed your number.");
                    correct = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }
        }

        if (!correct) {
            System.out.println("There seems to be a mistake in your responses.");
        }

        scanner.close();
    }

    // Function to generate the next guess
    public static int generateGuess(int low, int high) {
        return (low + high) / 2; // Binary search strategy
    }

    // Function to get user feedback
    public static String getUserFeedback(Scanner scanner) {
        return scanner.nextLine().trim().toLowerCase();
    }
}
