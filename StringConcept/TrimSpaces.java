import java.util.Scanner;

class TrimSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int[] trimIndexes = getTrimIndexes(text);
        String trimmedCustom = createSubstring(text, trimIndexes[0], trimIndexes[1]);
        String trimmedBuiltIn = text.trim();

        boolean isEqual = compareStrings(trimmedCustom, trimmedBuiltIn);

        System.out.println("Custom Trimmed: '" + trimmedCustom + "'");
        System.out.println("Built-in Trimmed: '" + trimmedBuiltIn + "'");
        System.out.println("Are both equal? " + isEqual);
    }

    public static int[] getTrimIndexes(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1};
    }

    public static String createSubstring(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}
