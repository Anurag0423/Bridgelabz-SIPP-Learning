import java.util.Scanner;

class CustomSplitComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] builtInSplit = text.split(" ");
        String[] customSplit = customSplit(text);
        boolean isEqual = compareArrays(builtInSplit, customSplit);

        System.out.println("Built-in Split:");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        System.out.println("Custom Split:");
        for (String word : customSplit) {
            System.out.println(word);
        }

        System.out.println("Are both arrays equal? " + isEqual);
    }

    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static String[] customSplit(String text) {
        int length = findLength(text);
        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaceIndexes = new int[wordCount + 1];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index++] = length;

        String[] words = new String[wordCount];
        int start = 0;
        for (int i = 0; i < wordCount; i++) {
            int end = spaceIndexes[i];
            StringBuilder sb = new StringBuilder();
            for (int j = start; j < end; j++) {
                sb.append(text.charAt(j));
            }
            words[i] = sb.toString();
            start = end + 1;
        }

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!compareStrings(arr1[i], arr2[i])) return false;
        }
        return true;
    }

    public static boolean compareStrings(String s1, String s2) {
        int len1 = findLength(s1);
        int len2 = findLength(s2);
        if (len1 != len2) return false;
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
}
