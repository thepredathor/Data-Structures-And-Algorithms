
package data_structures.map.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ArrayIntersection {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Compute the intersection of 2 arrays in O(N)
    // Eg: [1,2,3,4,5,6] intersected with [0,2,4] => [2.4]

    public static void main(String[] args) {
        int[] firstArray = { 1, 2, 3, 4, 5 };
        int[] secondArray = { 0, 2, 4, 6, 8 };

        System.out.println(Arrays.toString(arrayIntersection(firstArray, secondArray)));
    }

    public static int[] arrayIntersection(int[] firstArray, int[] secondArray) {
        HashMap<Integer, Integer> integerToIntegerHashMap = new HashMap<>();
        for (Integer i : firstArray) {
            integerToIntegerHashMap.put(i, 0); // create map of unique elements of first array and init values with 0
        }

        for (Integer i : secondArray) {
            Integer value = integerToIntegerHashMap.get(i);
            if (value != null) { // insert remaining values from second array into map as keys and init values with 0 else increase already value with 1
                integerToIntegerHashMap.put(i, value + 1);
            } else {
                integerToIntegerHashMap.put(i, 0);
            }
        }

        //J-
        return integerToIntegerHashMap.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .mapToInt(Map.Entry::getKey)
                .toArray();
            //collect keys with values different than 0 meaning the keys that have the values modified by the second array
        //J+
    }
}
