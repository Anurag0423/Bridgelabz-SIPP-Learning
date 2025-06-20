import java.util.Scanner;

class SumOfNaturalNumbers {
    public static int findSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = findSum(n);
        System.out.println("Sum of first " + n + " natural numbers: " + result);
        sc.close();
    }
}
