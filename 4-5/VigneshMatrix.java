import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VigneshMatrix {

    public static void main(String[] args) {

        try {

            // Read the file
            File file = new File("4-5\\MatrixInput.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            // Read each line
            while ((line = br.readLine()) != null) {

                // Parse the matrices
                int[][] matrix1;
                int[][] matrix2;
                matrix1 = parseMatrix(line.replace("  ", " ").split(" ")[0]);
                matrix2 = parseMatrix(line.replace("  ", " ").split(" ")[1]);

                // Print the matrices
                System.out.println("Matrix 1:");
                printMatrix(matrix1);

                System.out.println("Matrix 2:");
                printMatrix(matrix2);

                // Sum
                System.out.println("Sum:");
                printMatrix(addMatrices(matrix1, matrix2));

                // Difference
                System.out.println("Difference:");
                printMatrix(subtractMatricies(matrix1, matrix2));

                // Product
                System.out.println("Product:");
                printMatrix(multiplyMatrices(matrix1, matrix2));

                System.out.println("====================================");

            }

            br.close();
        } catch (IOException io) {
            System.err.println("File Error: " + io);
        }
    }

    public static int[][] addMatrices(int[][] A, int[][] B) {

        // Get the dimensions of the matrices
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        // Check Error Condition
        if (rowsA != rowsB || colsA != colsB) {
            return new int[][] { { 0 } };
        }

        // Add each element
        int[][] C = new int[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    public static int[][] subtractMatricies(int[][] A, int[][] B) {

        // Get the dimensions of the matrices
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        // Check Error Condition
        if (rowsA != rowsB || colsA != colsB) {
            return new int[][] { { 0 } };
        }

        // Subtract each element
        int[][] C = new int[rowsA][colsA];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }

        return C;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {

        // Get the dimensions of the matrices
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        int[][] C = new int[rowsA][colsB];

        // Check Error Condition
        if (colsA != rowsB) {
            return new int[][] { { 0 } };
        }

        // Formula:
        // https://www.baeldung.com/wp-content/uploads/2019/07/multiplicationAlgorithm-1.png
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    // Void method to print matrix in desired format
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Convert Input into x*y matrix
    public static int[][] parseMatrix(String str) {

        // Intialize the matrix
        str = str.replaceAll("\\s+", "");
        String[] matrixStringParts = str.trim().split("\\},\\{");
        String[] firstRowCols = matrixStringParts[0].replaceAll("[{}]", "").split(",");

        // Determine the dimensions (x*y) of the matrix
        int rows = matrixStringParts.length;
        int cols = firstRowCols.length;
        int[][] matrix = new int[rows][cols];

        // Parse the matrix
        for (int i = 0; i < rows; i++) {

            String[] rowStringParts = matrixStringParts[i].replaceAll("[{}]", "").split(",");
            if (rowStringParts.length != cols) {
                throw new IllegalArgumentException("goofy matrix");
            }
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(rowStringParts[j]);
            }

        }

        return matrix;
    }
}
