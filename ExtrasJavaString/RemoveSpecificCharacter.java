import java.util.Scanner;

public class RemoveSpecificCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = getInput(scanner);
        char charToRemove = getCharacterToRemove(scanner);
        String result = removeCharacter(input, charToRemove);

        System.out.println("Modified String: " + result);

        scanner.close();
    }

    // Function to get the input string
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a string: ");
        return scanner.nextLine();
    }

    // Function to get the character to remove
    public static char getCharacterToRemove(Scanner scanner) {
        System.out.print("Enter character to remove: ");
        return scanner.next().charAt(0);
    }

    // Function to remove the character from the string
    public static String removeCharacter(String str, char ch) {
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c != ch) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
