
package blind75.matrix;

import java.util.Arrays;


public class SetMatrixZeroes {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[][] ints = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
            };
        int[][] ints2 = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
            };
        setZeroes(ints);
        printMatrix(ints);
        setZeroes(ints2);
        printMatrix(ints2);
    }

    public static void setZeroes(int[][] matrix) {
        boolean firstRowContains0 = false;
        boolean firstColumnContains0 = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstRowContains0 = true;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstColumnContains0 = true;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if ((matrix[i][0] == 0) || (matrix[0][j] == 0)) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowContains0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstColumnContains0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
