import java.util.*;

public class StringBufferProblem2 {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        // --- StringBuilder Performance ---
        long startBuilder = System.nanoTime();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < iterations; i++) {
            builder.append(text);
        }

        long endBuilder = System.nanoTime();
        long durationBuilder = endBuilder - startBuilder;

        // --- StringBuffer Performance ---
        long startBuffer = System.nanoTime();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < iterations; i++) {
            buffer.append(text);
        }

        long endBuffer = System.nanoTime();
        long durationBuffer = endBuffer - startBuffer;

        // --- Output Results ---
        System.out.println("StringBuilder time (ms): " + durationBuilder / 1_000_000);
        System.out.println("StringBuffer  time (ms): " + durationBuffer / 1_000_000);
    }
}
