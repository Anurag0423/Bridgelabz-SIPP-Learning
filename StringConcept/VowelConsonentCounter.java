import java.util.Scanner;

class VowelConsonantCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int[] count = countVowelsAndConsonants(text);
        System.out.println("Vowels: " + count[0]);
        System.out.println("Consonants: " + count[1]);
    }

    public static String checkCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = checkCharType(text.charAt(i));
            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }
        return new int[]{vowels, consonants};
    }
}
