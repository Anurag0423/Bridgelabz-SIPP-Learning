import java.util.Scanner;

class BMICalculator {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100;
            data[i][2] = weight / (heightInMeters * heightInMeters);
        }
    }

    public static String[] determineStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi <= 18.4)
                status[i] = "Underweight";
            else if (bmi <= 24.9)
                status[i] = "Normal";
            else if (bmi <= 39.9)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] members = new double[10][3];

        for (int i = 0; i < 10; i++) {
            members[i][0] = sc.nextDouble();
            members[i][1] = sc.nextDouble();
        }

        calculateBMI(members);
        String[] statuses = determineStatus(members);

        for (int i = 0; i < 10; i++) {
            System.out.printf("Person %d - Weight: %.1f kg, Height: %.1f cm, BMI: %.2f, Status: %s%n",
                    (i + 1), members[i][0], members[i][1], members[i][2], statuses[i]);
        }

        sc.close();
    }
}
