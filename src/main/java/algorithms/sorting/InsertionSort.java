package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int [] array = {5, 1, 0, 2, 10, 4, 3, 7, 6};
        int [] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(insertionSort(array)));
        System.out.println(Arrays.toString(insertionSort(array2)));
    }

    // 1) Time complexity still considered O(N^2) because of worst case scenario. Average case may be closer to O(N)
    // 2) Insertion sort name because of selecting first the element and index that needs to be inserted elsewhere in the array
    // 3) Starts from "insertionIndex" = i = 1 by taking the element at "insertionIndex" and compares it with elements on the left side of "insertionIndex"
    // 4) If left element is bigger => paste left element at "insertionIndex" and decrement "insertionIndex"; else break or nothing
    // 5) Continue until "insertionIndex" is 0
    // 6) Increment i
    public static int[] insertionSort(int [] array) {
        for(int i = 1; i < array.length; i++) {         // from i = 1 until the end of array; i starts from 1 because of left side needing to have one element
            int insertionNumber = array[i];             // store temporary number at index i
            int insertionIndex = i;                     // store temporary index
            for(int j = i -1; j >= 0; j--) {            // from j = i -1 until beginning descending
                if(array[j] > insertionNumber) {        // if left side is bigger than pivot element
                    array[insertionIndex] = array[j];   // copy left side to current index
                    insertionIndex--;                   // decrement the index where the temporary value needs to go
                }                                       // else do nothing for the remaining left side numbers until j = 0
            }
            array[insertionIndex] = insertionNumber;    // insert the temporary starting number to correct position
        }
        return array;
    }

}
