package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] array = {5, 1, 0, 2, 10, 4, 3, 7, 6};
        int [] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(bubbleSort(array)));
        System.out.println(Arrays.toString(bubbleSort(array2)));
    }

    // 1) Time complexity = close to O(N^2) worst case scenario
    // 2) Bubble sort name because each iteration bubbles the largest number to the correct position
    // 3) Keeps 2 sliding indexes until the end of array (i and i + 1)
    // 4) Compares the 2 values at said indexes
    // 5) Each iteration a number will be sorted correctly => can skip that number in the next iteration
    //      => each iteration skip number of already sorted elements
    public static int[] bubbleSort(int [] array) {
        boolean notSorted = true;                                   // we suppose the array is not sorted
        int passes = 0;                                             // passes or iterations until array is sorted
        while(notSorted) {                                          // condition will be met when array is sorted
            notSorted = false;                                      // we suppose the array is sorted from the get go
            for(int i = 0; i < array.length - 1 - passes; i++) {    // loop on all numbers minus the ones that have already been sorted
                if(array[i] > array[i+1]) {                         // if value of current index is bigger than value of next index we swap them
                    int tempInt = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tempInt;
                    notSorted = true;                               // status of array becomes not sorted again
                }
            }
            passes++;                                               // a number gets sorted at each iteration => increment the passes/iterations/numbers to be skipped for next iteration
        }

        return array;                                               // return sorted array
    }
}
