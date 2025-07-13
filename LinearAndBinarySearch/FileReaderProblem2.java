import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//WordCountInFile
public class FileReaderProblem2 {
    public static void main(String[] args) {
        String filePath = "example.txt"; // 🔁 Replace with your actual file path
        String targetWord = "java";      // 🔁 Word to search for (case-insensitive)
        int count = 0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // Normalize line and word for case-insensitive comparison
                String[] words = line.toLowerCase().split("\\W+"); // Split by non-word characters
                for (String word : words) {
                    if (word.equals(targetWord.toLowerCase())) {
                        count++;
                    }
                }
            }

            System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
