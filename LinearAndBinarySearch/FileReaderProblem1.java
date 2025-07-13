import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderProblem1 {
    public static void main(String[] args) {
        String filePath = "example.txt"; // 🔁 Replace with your actual file path

        // Step 1 & 2: Create FileReader and wrap it with BufferedReader
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            // Step 3: Read each line using readLine()
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // Step 4: Handle exceptions properly
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
