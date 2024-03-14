
package data_structures.map.problems;

import java.util.HashMap;


public class TwoSum {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Given an array of numbers and a sum number, return true if array contains 2 numbers adding up to the sum
    // Eg: {2,0,4,1,7,9}, sum=10 => return true (as 1,9 add up to 10)
    public static void main(String[] args) {
        int[] array = { 2, 0, 4, 1, 7, 9 };
        System.out.println(twoSumInArray(array, 10));
    }

    public static boolean twoSumInArray(int[] array, int sum) {
        HashMap<Integer, Boolean> integerBooleanHashMap = new HashMap<>();

        for (int i : array) { // for each int in array
            integerBooleanHashMap.put(i, true); // we put current int in our hashmap
            if (Boolean.TRUE.equals(integerBooleanHashMap.get(sum - i))) { // if sum - current int is in our hashmap we found the numbers that add up to the sum
                return true;
            }
        }

        return false;
    }
}
