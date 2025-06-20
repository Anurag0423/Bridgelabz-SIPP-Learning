import java.util.Random;

class MatrixManipulations {

    public static double[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10);
            }
        }
        return matrix;
    }

    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] trans = new double[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                trans[i][j] = matrix[j][i];
            }
        }
        return trans;
    }

    public static double determinant2x2(double[][] m) {
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    public static double determinant3x3(double[][] m) {
        return m[0][0]*(m[1][1]*m[2][2] - m[1][2]*m[2][1])
             - m[0][1]*(m[1][0]*m[2][2] - m[1][2]*m[2][0])
             + m[0][2]*(m[1][0]*m[2][1] - m[1][1]*m[2][0]);
    }

    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0) return null;
        double[][] inv = {
            { m[1][1]/det, -m[0][1]/det },
            { -m[1][0]/det, m[0][0]/det }
        };
        return inv;
    }

    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0) return null;
        double[][] cof = new double[3][3];

        cof[0][0] = (m[1][1]*m[2][2] - m[1][2]*m[2][1]);
        cof[0][1] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]);
        cof[0][2] = (m[1][0]*m[2][1] - m[1][1]*m[2][0]);

        cof[1][0] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]);
        cof[1][1] = (m[0][0]*m[2][2] - m[0][2]*m[2][0]);
        cof[1][2] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]);

        cof[2][0] = (m[0][1]*m[1][2] - m[0][2]*m[1][1]);
        cof[2][1] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]);
        cof[2][2] = (m[0][0]*m[1][1] - m[0][1]*m[1][0]);

        double[][] adj = transpose(cof);
        double[][] inv = new double[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inv[i][j] = adj[i][j] / det;
            }
        }

        return inv;
    }

    public static void displayMatrix(String title, double[][] matrix) {
        System.out.println(title);
        if (matrix == null) {
            System.out.println("Matrix not invertible (determinant = 0)\n");
            return;
        }
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%8.3f", val);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double[][] matrix2x2 = generateMatrix(2, 2);
        double[][] matrix3x3 = generateMatrix(3, 3);

        displayMatrix("2x2 Matrix:", matrix2x2);
        displayMatrix("Transpose 2x2:", transpose(matrix2x2));
        System.out.println("Determinant 2x2: " + determinant2x2(matrix2x2));
        displayMatrix("Inverse 2x2:", inverse2x2(matrix2x2));

        displayMatrix("3x3 Matrix:", matrix3x3);
        displayMatrix("Transpose 3x3:", transpose(matrix3x3));
        System.out.println("Determinant 3x3: " + determinant3x3(matrix3x3));
        displayMatrix("Inverse 3x3:", inverse3x3(matrix3x3));
    }
}
