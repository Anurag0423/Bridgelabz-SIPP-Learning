import java.util.Random;

class RectangleMatrix {

    public static int[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = b[0].length;
        int common = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static void displayMatrix(String name, int[][] matrix) {
        System.out.println(name);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] A = generateMatrix(2, 3); 
        int[][] B = generateMatrix(3, 2); 

        int[][] AB = multiplyMatrices(A, B); 
        int[][] BA = multiplyMatrices(B, A); 

        displayMatrix("Matrix A (2x3):", A);
        displayMatrix("Matrix B (3x2):", B);
        displayMatrix("Matrix AB (2x2):", AB);
        displayMatrix("Matrix BA (3x3):", BA);
    }
}
