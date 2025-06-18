import java.util.Scanner;

class CharArrayComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        char[] customArray = getCharacters(text);
        char[] builtInArray = text.toCharArray();
        boolean isEqual = compareCharArrays(customArray, builtInArray);

        System.out.println("Custom char array: " + new String(customArray));
        System.out.println("Built-in char array: " + new String(builtInArray));
        System.out.println("Are both arrays equal: " + isEqual);
    }

    public static char[] getCharacters(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
