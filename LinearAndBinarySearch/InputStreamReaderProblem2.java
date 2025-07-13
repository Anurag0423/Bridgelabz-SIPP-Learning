import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;
//ConsoleInputToFile
public class InputStreamReaderProblem2 {
    public static void main(String[] args) {
        String filePath = "output.txt"; // 🔁 Replace with your desired output file path

        // Step 1 & 2: Create InputStreamReader and wrap in BufferedReader
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader consoleReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath)) {

            String line;

            System.out.println("Enter text (type 'exit' to finish):");

            // Step 4: Read input and write to file until "exit" is entered
            while ((line = consoleReader.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                fileWriter.write(line + System.lineSeparator()); // Write each line followed by a new line
            }

            System.out.println("Input saved to file: " + filePath);

        } catch (IOException e) {
            System.err.println("Error during input/output: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
