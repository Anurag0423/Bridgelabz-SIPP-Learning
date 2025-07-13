import java.io.*;
//4. Problem Statement: Large File Reading Efficiency
public class LargeFileReadComparison {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Change to your actual file path

        // Using FileReader
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            long start = System.nanoTime();
            while (br.readLine() != null) {
                // just read, don't print
            }
            long end = System.nanoTime();
            System.out.println("FileReader time: " + (end - start) / 1_000_000.0 + " ms");

        } catch (IOException e) {
            System.out.println("FileReader failed: " + e.getMessage());
        }

        // Using InputStreamReader
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8");
             BufferedReader br2 = new BufferedReader(isr)) {

            long start = System.nanoTime();
            while (br2.readLine() != null) {
                // just read, don't print
            }
            long end = System.nanoTime();
            System.out.println("InputStreamReader time: " + (end - start) / 1_000_000.0 + " ms");

        } catch (IOException e) {
            System.out.println("InputStreamReader failed: " + e.getMessage());
        }
    }
}
