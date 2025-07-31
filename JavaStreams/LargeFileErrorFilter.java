import java.io.*;

public class LargeFileErrorFilter {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Replace with actual large file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                    count++;
                }
            }

            System.out.println(LargeFileErrorFilter"\n Total lines with 'error': " + count);
        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }
}
