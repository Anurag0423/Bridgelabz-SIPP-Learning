import java.util.Scanner;

class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;
        System.out.println("Enter the heights (in cm or m) of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = sc.nextDouble();
            sum += heights[i];  // Step 3: Add to sum
        }
        double mean = sum / heights.length;

        System.out.printf("\nMean height of the football team: %.2f\n", mean);

        sc.close();
    }
}
