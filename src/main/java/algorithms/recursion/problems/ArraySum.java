package algorithms.recursion.problems;

import java.util.Arrays;

public class ArraySum {

    // Problem:
    // Sum all elements of an integer array with recursion
    // Eg: [1,2,3,4,5] => 15
    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4, 5};
        System.out.println(arraySum(array));
    }

    public static int arraySum(int [] array) {
        if(array.length == 1) {                                             // base case: if array contains one element => overflow/out of bounds otherwise
            return array[0];                                                // return that element
        }

        int [] subArray = Arrays.copyOfRange(array, 1, array.length);  // make a copy of the array starting from index 1 until array's length

        return array[0] + arraySum(subArray);                               // return first element + recursive call of subArray from index 1 to array's length
    }
}
