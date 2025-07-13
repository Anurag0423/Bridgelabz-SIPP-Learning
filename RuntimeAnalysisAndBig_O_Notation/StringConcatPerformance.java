//3. Problem Statement: String Concatenation Performance
public class StringConcatPerformance {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};

        for (int size : sizes) {
            System.out.println("\nConcatenating " + size + " strings:");

            // String (Inefficient - O(N²))
            long start1 = System.nanoTime();
            String s = "";
            for (int i = 0; i < size; i++) {
                s += "a"; // creates new object each time
            }
            long end1 = System.nanoTime();
            System.out.println("String time:       " + (end1 - start1) / 1_000_000.0 + " ms");

            // StringBuilder (Efficient - O(N))
            long start2 = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append("a");
            }
            long end2 = System.nanoTime();
            System.out.println("StringBuilder time:" + (end2 - start2) / 1_000_000.0 + " ms");

            // StringBuffer (Thread-safe, slightly slower - O(N))
            long start3 = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < size; i++) {
                sbf.append("a");
            }
            long end3 = System.nanoTime();
            System.out.println("StringBuffer time: " + (end3 - start3) / 1_000_000.0 + " ms");
        }
    }
}
