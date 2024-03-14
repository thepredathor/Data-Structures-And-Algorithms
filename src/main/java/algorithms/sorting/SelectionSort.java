package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] array = {5, 1, 0, 2, 10, 4, 3, 7, 6};
        int [] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(selectionSort(array)));
        System.out.println(Arrays.toString(selectionSort(array2)));
    }

    // 1) Time complexity = close to O(N^2) worst case scenario even though it is twice as fast as bubble sort (O((N^2)/2))
    // 2) Selection sort name because it selects the smallest number in the iteration and it puts it in the current index(correct position).
    // 3) Finds smallest number in iteration bound (currentIndex, array.length)
    // 4) Swaps smallest number with the current array index value
    // 5) Increments current index by 1 with each iteration
    public static int[] selectionSort(int [] array) {
        int currentIndexToBeSorted = 0;                                         //index in which the smallest number will be put

        while (currentIndexToBeSorted != array.length) {                        // current index will be incremented until the length of the array
            int iterationSmallestNumber = array[currentIndexToBeSorted];        // we suppose the smallest number to be the first element at current index that needs sorting
            int indexOfIterationSmallestNumber = currentIndexToBeSorted;        // we supposed the index of the smallest number to be the current index that needs sorting

            for(int i = 0 + currentIndexToBeSorted; i < array.length; i++) {    // loop on all numbers from current index that needs sorting until end of array
                if(array[i] < iterationSmallestNumber) {                        // if a smaller number is found
                    iterationSmallestNumber = array[i];                         // store it
                    indexOfIterationSmallestNumber = i;                         // and save its index
                }
            }
            int tempNumber = array[indexOfIterationSmallestNumber];             // swap the value at current index that needs sorting with the smallest number found
            array[indexOfIterationSmallestNumber] = array[currentIndexToBeSorted];
            array[currentIndexToBeSorted] = tempNumber;
            currentIndexToBeSorted++;                                           // increment the current index that needs sorting
        }

        return array;
    }
}
