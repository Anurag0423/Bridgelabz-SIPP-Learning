import java.util.Scanner;

class WordLength2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = splitText(text);
        String[][] wordData = getWordLengthArray(words);

        System.out.println("Word\tLength");
        for (int i = 0; i < wordData.length; i++) {
            System.out.println(wordData[i][0] + "\t" + Integer.parseInt(wordData[i][1]));
        }
    }

    public static String[] splitText(String text) {
        int len = getLength(text);
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') wordCount++;
        }

        int[] spaceIndexes = new int[wordCount + 1];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index++] = len;

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

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }
}
