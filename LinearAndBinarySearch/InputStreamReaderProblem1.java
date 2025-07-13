import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
//ByteToCharStream
public class InputStreamReaderProblem1 {
    public static void main(String[] args) {
        String filePath = "example.txt"; // 🔁 Replace with your actual file path

        // Step 1 & 2: Create FileInputStream and wrap it in InputStreamReader with charset
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;

            // Step 4: Read the file line by line and print each line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            // Step 5: Handle any I/O or encoding exceptions
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
