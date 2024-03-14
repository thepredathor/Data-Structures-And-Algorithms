
package blind75.matrix;

import java.util.Arrays;


public class RotateImage {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[][] ints = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
            };
        int[][] ints2 = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
            };
        rotate(ints);
        rotate(ints2);
        SetMatrixZeroes.printMatrix(ints);
        SetMatrixZeroes.printMatrix(ints2);
    }

    public static void rotate(int[][] matrix) {
        for (int i = 0, j = matrix.length - 1; i < j; i++, j--) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
