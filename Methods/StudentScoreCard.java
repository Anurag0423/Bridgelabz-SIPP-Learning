import java.util.Scanner;
import java.util.Random;

class StudentScoreCardWithGrades {

    public static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + rand.nextInt(90);
            }
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        int n = scores.length;
        double[][] results = new double[n][3];
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static String[] calculateGrade(double percentage) {
        String[] gradeRemark = new String[2];
        if (percentage >= 80) {
            gradeRemark[0] = "A";
            gradeRemark[1] = "Level 4, above agency-normalized standards";
        } else if (percentage >= 70) {
            gradeRemark[0] = "B";
            gradeRemark[1] = "Level 3, at agency-normalized standards";
        } else if (percentage >= 60) {
            gradeRemark[0] = "C";
            gradeRemark[1] = "Level 2, below but approaching standards";
        } else if (percentage >= 50) {
            gradeRemark[0] = "D";
            gradeRemark[1] = "Level 1, well below standards";
        } else if (percentage >= 40) {
            gradeRemark[0] = "E";
            gradeRemark[1] = "Level 1-, too below standards";
        } else {
            gradeRemark[0] = "R";
            gradeRemark[1] = "Remedial standards";
        }
        return gradeRemark;
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("\nStudent\tPhy\tChem\tMath\tTotal\tAvg\t%age\tGrade\tRemarks");
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            double total = results[i][0];
            double avg = results[i][1];
            double percentage = results[i][2];

            String[] gradeRemark = calculateGrade(percentage);

            System.out.print(total + "\t" + avg + "\t" + percentage + "\t" + gradeRemark[0] + "\t");
            System.out.println(gradeRemark[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] scores = generateScores(n);
        double[][] results = calculateResults(scores);
        displayScorecard(scores, results);
        sc.close();
    }
}
