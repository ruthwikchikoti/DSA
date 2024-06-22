import java.util.Scanner;

public class GaussJordanElimination {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of variables: ");
        int n = scanner.nextInt();

        System.out.println("Enter the augmented matrix:");

        double[][] matrix = new double[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print("Enter element matrix[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextDouble();
            }
        }

        gaussJordanElimination(matrix);

        System.out.println("Solution:");
        printMatrix(matrix);

        scanner.close();
    }

    public static void gaussJordanElimination(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            // Make the diagonal element 1
            double diagonalElement = matrix[i][i];
            if (diagonalElement != 0) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] /= diagonalElement;
                }
            } else {
                System.out.println("Error: Division by zero is not possible.");
                return;
            }
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}