import java.util.Scanner;

class LowerCaseComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String customLower = convertToLower(text);
        String builtInLower = text.toLowerCase();
        boolean isEqual = compareStrings(customLower, builtInLower);

        System.out.println("Custom lowercase: " + customLower);
        System.out.println("Built-in lowercase: " + builtInLower);
        System.out.println("Are both lowercase strings equal: " + isEqual);
    }

    public static String convertToLower(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
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
