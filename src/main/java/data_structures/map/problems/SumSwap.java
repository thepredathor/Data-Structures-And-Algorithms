
package data_structures.map.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class SumSwap {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
//        int[] array1 = new int[] { 5, 3, 3, 7 };
//        int[] array2 = new int[] { 4, 1, 1, 6 };
//        int[] array1 = new int[] { 1, 2, 3, 4, 5 };
//        int[] array2 = new int[] { 6, 7, 8 };
        int[] array1 = new int[] { 10, 15, 20 };
        int[] array2 = new int[] { 5, 30 };

        System.out.println(Arrays.toString(indicesOfSumSwapElements(array1, array2)));
    }

    public static int[] indicesOfSumSwapElements(int[] array1, int[] array2) {
        int sumArray1 = 0;
        int sumArray2 = 0;
        Map<Integer, Integer> array1NumbersToIndicesMap = new HashMap<>();
        for (int i = 0; i < array1.length; i++) {
            sumArray1 += array1[i];
            array1NumbersToIndicesMap.put(array1[i], i);
        }
        for (int i : array2) {
            sumArray2 += i;
        }

        int halfOfDifferenceSum = Math.abs(sumArray1 - sumArray2) / 2;
        if (sumArray1 > sumArray2) {
            for (int i = 0; i < array2.length; i++) {
                Integer array1NumberIndex = array1NumbersToIndicesMap.get(array2[i] + halfOfDifferenceSum);
                if (array1NumberIndex != null) {
                    return new int[] { array1NumberIndex, i };
                }
            }
        } else {
            for (int i = 0; i < array2.length; i++) {
                for (int j = 0; j < array2.length; j++) {
                    Integer array1NumberIndex = array1NumbersToIndicesMap.get(array2[j] - halfOfDifferenceSum);
                    if (array1NumberIndex != null) {
                        return new int[] { array1NumberIndex, j };
                    }
                }
            }
        }

        return null;
    }
}
