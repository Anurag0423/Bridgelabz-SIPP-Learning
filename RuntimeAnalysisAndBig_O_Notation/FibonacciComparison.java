//5. Problem Statement: Recursive vs Iterative Fibonacci Computation
public class FibonacciComparison {
    public static void main(String[] args) {
        int[] testValues = {10, 30}; // Avoid 50+ for recursive to prevent huge delay

        for (int n : testValues) {
            System.out.println("\nFibonacci Number: " + n);

            // Recursive Fibonacci
            long startRec = System.nanoTime();
            int fibRec = fibonacciRecursive(n);
            long endRec = System.nanoTime();
            System.out.println("Recursive Result: " + fibRec + ", Time: " + (endRec - startRec) / 1_000_000.0 + " ms");

            // Iterative Fibonacci
            long startItr = System.nanoTime();
            int fibItr = fibonacciIterative(n);
            long endItr = System.nanoTime();
            System.out.println("Iterative Result: " + fibItr + ", Time: " + (endItr - startItr) / 1_000_000.0 + " ms");
        }

        // Optional: Large n test (skip recursive)
        int largeN = 50;
        long startItr = System.nanoTime();
        int fibLarge = fibonacciIterative(largeN);
        long endItr = System.nanoTime();
        System.out.println("\nFibonacci(" + largeN + ") Iterative Only: " + fibLarge + ", Time: " + (endItr - startItr) / 1_000_000.0 + " ms");
    }

    // Recursive Fibonacci (Inefficient)
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Efficient)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
