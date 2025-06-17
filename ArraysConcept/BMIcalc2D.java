import java.util.Scanner;

class BMICalculator2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int number = scanner.nextInt();
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));
            System.out.print("Enter weight in kg: ");
            double weight = scanner.nextDouble();
            if (weight <= 0) {
                System.out.println("Invalid weight. Please enter a positive value.");
                i--;
                continue;
            }
            System.out.print("Enter height in meters: ");
            double height = scanner.nextDouble();
            if (height <= 0) {
                System.out.println("Invalid height. Please enter a positive value.");
                i--;
                continue;
            }
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height); 
            double bmi = personData[i][2];
            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.printf("Weight: %.2f kg\n", personData[i][0]);
            System.out.printf("Height: %.2f meters\n", personData[i][1]);
            System.out.printf("BMI: %.2f\n", personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
        }

        scanner.close();
    }
}
