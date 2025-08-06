import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        // Try-with-resources automatically closes the BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {
            String firstLine = br.readLine(); // Read first line
            System.out.println("First line: " + firstLine);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
