
package blind75.matrix;

import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int[][] ints = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
            };
        System.out.println(spiralOrder(ints));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> elementSpiralOrder = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int r1 = 0;
        int c1 = 0;
        int r2 = rows - 1;
        int c2 = columns - 1;

        while (elementSpiralOrder.size() < (rows * columns)) {
            for (int i = c1; (i <= c2) && (elementSpiralOrder.size() < (rows * columns)); i++) {
                elementSpiralOrder.add(matrix[r1][i]);
            }
            for (int i = r1 + 1; (i <= (r2 - 1)) && (elementSpiralOrder.size() < (rows * columns)); i++) {
                elementSpiralOrder.add(matrix[i][c2]);
            }
            for (int i = c2; (i >= c1) && (elementSpiralOrder.size() < (rows * columns)); i--) {
                elementSpiralOrder.add(matrix[r2][i]);
            }
            for (int i = r2 - 1; (i >= (r1 + 1)) && (elementSpiralOrder.size() < (rows * columns)); i--) {
                elementSpiralOrder.add(matrix[i][c1]);
            }

            r1++;
            c1++;
            r2--;
            c2--;
        }

        return elementSpiralOrder;
    }
}
