import java.util.*;

class NumberChecker {

    public static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    public static int[] getDigits(int number) {
        String numStr = String.valueOf(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    public static boolean isHarshad(int number, int[] digits) {
        return number % sumOfDigits(digits) == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
            freq[i][1] = 0;
        }
        for (int d : digits) {
            freq[d][1]++;
        }
        return freq;
    }

    public static void main(String[] args) {
        int number = 122344;

        int count = countDigits(number);
        int[] digits = getDigits(number);
        int sum = sumOfDigits(digits);
        int squareSum = sumOfSquares(digits);
        boolean harshad = isHarshad(number, digits);
        int[][] frequency = digitFrequency(digits);

        System.out.println("Number: " + number);
        System.out.println("Digit Count: " + count);
        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();
        System.out.println("Sum of Digits: " + sum);
        System.out.println("Sum of Squares of Digits: " + squareSum);
        System.out.println("Is Harshad Number: " + harshad);
        System.out.println("Digit Frequencies:");
        for (int[] f : frequency) {
            if (f[1] > 0) {
                System.out.println("Digit " + f[0] + ": " + f[1]);
            }
        }
    }
}
