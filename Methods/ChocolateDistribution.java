import java.util.Scanner;

class ChocolateDistribution {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int[] result = new int[2];
        result[0] = number / divisor;
        result[1] = number % divisor;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfChocolates = sc.nextInt();
        int numberOfChildren = sc.nextInt();

        if (numberOfChildren == 0) {
            System.out.println("Division by zero is not allowed.");
        } else {
            int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
            System.out.println("Chocolates each child gets: " + result[0]);
            System.out.println("Remaining chocolates: " + result[1]);
        }

        sc.close();
    }
}
