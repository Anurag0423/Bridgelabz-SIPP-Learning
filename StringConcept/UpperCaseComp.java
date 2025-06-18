import java.util.Scanner;

class UpperCaseComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String customUpper = convertToUpper(text);
        String builtInUpper = text.toUpperCase();
        boolean isEqual = compareStrings(customUpper, builtInUpper);

        System.out.println("Custom uppercase: " + customUpper);
        System.out.println("Built-in uppercase: " + builtInUpper);
        System.out.println("Are both uppercase strings equal: " + isEqual);
    }

    public static String convertToUpper(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
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
