import java.io.*;
import java.nio.charset.StandardCharsets;

public class ChallengeProblem {
    public static void main(String[] args) {
        String word = "hello";
        int times = 1_000_000;
        String filePath = "largefile.txt"; // 🔁 Change this to your 100MB file path

        // === STRING CONCATENATION ===
        System.out.println("=== String Concatenation ===");

        // StringBuilder
        long start1 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(word);
        }
        long end1 = System.nanoTime();
        System.out.println("StringBuilder time (ms): " + (end1 - start1) / 1_000_000);

        // StringBuffer
        long start2 = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < times; i++) {
            sbuf.append(word);
        }
        long end2 = System.nanoTime();
        System.out.println("StringBuffer time (ms): " + (end2 - start2) / 1_000_000);


        // === FILE READING AND WORD COUNT ===
        System.out.println("\n=== File Reading & Word Count ===");

        // FileReader
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            long start = System.nanoTime();
            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.trim().split("\\s+").length;
            }
            long end = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount);
            System.out.println("FileReader time (ms): " + (end - start) / 1_000_000);
        } catch (IOException e) {
            System.out.println("Error reading with FileReader: " + e.getMessage());
        }

        // InputStreamReader
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {

            long start = System.nanoTime();
            int wordCount = 0;
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.trim().split("\\s+").length;
            }
            long end = System.nanoTime();
            System.out.println("InputStreamReader word count: " + wordCount);
            System.out.println("InputStreamReader time (ms): " + (end - start) / 1_000_000);
        } catch (IOException e) {
            System.out.println("Error reading with InputStreamReader: " + e.getMessage());
        }
    }
}
