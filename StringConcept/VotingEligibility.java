import java.util.Random;
import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStudents = 10;

        int[] ages = generateAges(numStudents);
        String[][] result = checkVotingEligibility(ages);
        displayResult(result);
    }

    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90) + 10;
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0 || ages[i] < 18) {
                result[i][1] = "false";
            } else {
                result[i][1] = "true";
            }
        }
        return result;
    }

    public static void displayResult(String[][] data) {
        System.out.println("Age\tCan Vote");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }
}
