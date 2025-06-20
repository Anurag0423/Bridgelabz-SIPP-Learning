import java.util.Scanner;

class LineDistanceCalculator {

    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        double dx = Math.pow(x2 - x1, 2);
        double dy = Math.pow(y2 - y1, 2);
        return Math.sqrt(dx + dy);
    }

    public static double[] calculateLineEquation(int x1, int y1, int x2, int y2) {
        double m = (double)(y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return new double[] {m, b};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1: ");
        int x1 = sc.nextInt();
        System.out.print("Enter y1: ");
        int y1 = sc.nextInt();
        System.out.print("Enter x2: ");
        int x2 = sc.nextInt();
        System.out.print("Enter y2: ");
        int y2 = sc.nextInt();

        double distance = calculateDistance(x1, y1, x2, y2);
        double[] line = calculateLineEquation(x1, y1, x2, y2);

        System.out.printf("Euclidean Distance = %.2f\n", distance);
        System.out.printf("Line Equation: y = %.2fx + %.2f\n", line[0], line[1]);

        sc.close();
    }
}
