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

    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean areArraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseDigits(digits);
        return areArraysEqual(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 12021;

        int count = countDigits(number);
        int[] digits = getDigits(number);
        int[] reversed = reverseDigits(digits);
        boolean isPalin = isPalindrome(digits);
        boolean isDuck = isDuckNumber(digits);

        System.out.println("Number: " + number);
        System.out.println("Digit Count: " + count);
        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();
        System.out.print("Reversed Digits: ");
        for (int d : reversed) System.out.print(d + " ");
        System.out.println();
        System.out.println("Is Palindrome: " + isPalin);
        System.out.println("Is Duck Number: " + isDuck);
    }
}
