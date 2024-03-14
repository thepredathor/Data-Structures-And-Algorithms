package algorithms.searching;

import java.util.Arrays;

import static algorithms.sorting.InsertionSort.insertionSort;

public class BinarySearch {
    public static void main(String[] args) {
        int [] array = {5, 1, 0, 2, 10, 4, 3, 7, 6};
        int [] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(binarySearch(insertionSort(array), 5));
        System.out.println(binarySearch(insertionSort(array2), 10));
        System.out.println(binarySearch(insertionSort(array2), 11));
    }

    public static boolean binarySearch(int [] array, int numberToBeFound) {
        if(array.length == 1) {
            return numberToBeFound == array[0];
        }
        int pivotIndex = array.length/2;

        if(numberToBeFound == array[array.length/2]) {
            return true;
        }

        if(numberToBeFound < array[array.length/2]) {
            return binarySearch(Arrays.copyOfRange(array, 0, array.length/2), numberToBeFound);
        }

        if(numberToBeFound > array[pivotIndex]) {
            return binarySearch(Arrays.copyOfRange(array, array.length/2, array.length), numberToBeFound);
        }

        return false;
    }
}
