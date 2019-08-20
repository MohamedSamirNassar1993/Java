package firstlab;

public class DoubleTranspositionCipher {

    public static void main(String[] args) {
        // Input plaintext
        String plaintext = "ATTACK AT DAWN";

        // Create matrices
        char[][] matrixPlain = new char[10][10];
        char[][] matrixCipher = new char[10][10];

        // Fill Matrix
        matrixPlain = fillMatrix(plaintext);

        // Swap/Print
        matrixCipher = swapMatrix(matrixPlain);
        matrixCipher = swapMatrix(matrixCipher);
        printMatrix(matrixCipher);

    }

    public static char[][] fillMatrix(String input) {
        char[][] result = new char[10][10];
        for (int i = 0; i < 100; i++) {
            int row = i / 10;
            int col = i % 10;
            result[row][col] = input.charAt(i);
        }
        return result;
    }

    public static char[][] swapMatrix(char[][] matrix) {
        for (int i = 0; i < 10; i++) {
            char temp = matrix[i][0];
            for (int j = 0; j < 10 - 1; j++) {
                matrix[i][j] = matrix[i][j + 1];
            }
            matrix[i][10 - 1] = temp;
        }
        return matrix;
    }

    public static void printMatrix(char[][] input) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(input[i][j] + " ");
            }
        }
    }
}
