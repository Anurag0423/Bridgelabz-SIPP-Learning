import java.util.*;

class TextAnalysis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] wordWithLength = wordLengthArray(words);
        int[] minMaxIndex = findShortestAndLongest(wordWithLength);

        System.out.println("\nWord\tLength");
        for (String[] row : wordWithLength) {
            System.out.println(row[0] + "\t" + row[1]);
        }

        System.out.println("\nShortest Word: " + wordWithLength[minMaxIndex[0]][0]);
        System.out.println("Longest Word: " + wordWithLength[minMaxIndex[1]][0]);
    }

    public static String[] splitWords(String text) {
        int len = getLength(text);
        ArrayList<String> words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else if (!word.equals("")) {
                words.add(word);
                word = "";
            }
        }
        if (!word.equals("")) {
            words.add(word);
        }
        return words.toArray(new String[0]);
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

    public static String[][] wordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            int len = getLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }
        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordArr) {
        int minIndex = 0, maxIndex = 0;
        int min = Integer.parseInt(wordArr[0][1]);
        int max = Integer.parseInt(wordArr[0][1]);

        for (int i = 1; i < wordArr.length; i++) {
            int length = Integer.parseInt(wordArr[i][1]);
            if (length < min) {
                min = length;
                minIndex = i;
            }
            if (length > max) {
                max = length;
                maxIndex = i;
            }
        }
        return new int[]{minIndex, maxIndex};
    }
}
