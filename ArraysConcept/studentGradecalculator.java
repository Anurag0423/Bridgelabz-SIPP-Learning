import java.util.Scanner;

class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] physics = new int[numStudents];
        int[] chemistry = new int[numStudents];
        int[] maths = new int[numStudents];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + " (0 to 100):");
            System.out.print("Physics: ");
            physics[i] = scanner.nextInt();
            if (physics[i] < 0 || physics[i] > 100) {
                System.out.println("Invalid marks. Please enter positive marks between 0-100.");
                i--;
                continue;
            }
            System.out.print("Chemistry: ");
            chemistry[i] = scanner.nextInt();
            if (chemistry[i] < 0 || chemistry[i] > 100) {
                System.out.println("Invalid marks. Please enter positive marks between 0-100.");
                i--;
                continue;
            }
            System.out.print("Maths: ");
            maths[i] = scanner.nextInt();
            if (maths[i] < 0 || maths[i] > 100) {
                System.out.println("Invalid marks. Please enter positive marks between 0-100.");
                i--;
                continue;
            }
            int total = physics[i] + chemistry[i] + maths[i];
            percentages[i] = total / 3.0;
            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        System.out.println("\n--- Student Results ---");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.println("Physics: " + physics[i]);
            System.out.println("Chemistry: " + chemistry[i]);
            System.out.println("Maths: " + maths[i]);
            System.out.printf("Percentage: %.2f%%\n", percentages[i]);
            System.out.println("Grade: " + grades[i]);
        }

        scanner.close();
    }
}
