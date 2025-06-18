import java.util.Scanner;

class SubstringComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        String customSub = createSubstring(text, start, end);
        String builtInSub = text.substring(start, end);
        boolean isEqual = compareStrings(customSub, builtInSub);

        System.out.println("Custom substring: " + customSub);
        System.out.println("Built-in substring: " + builtInSub);
        System.out.println("Are both substrings equal: " + isEqual);
    }

    public static String createSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
