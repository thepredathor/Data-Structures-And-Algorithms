
package algorithms.sorting.recursion;

import java.util.Arrays;


public class QuickSort {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields 
    //~ ----------------------------------------------------------------------------------------------------------------

    public int[] intArray;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors 
    //~ ----------------------------------------------------------------------------------------------------------------

    public QuickSort(int[] intArray) {
        this.intArray = intArray;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort(new int[] { 0, 5, 2, 1, 6, 3 });
        quickSort.quickSort();
        System.out.println(Arrays.toString(quickSort.intArray));
    }

    public int partition(int leftIndex, int rightIndex) {
        int pivotIndex = rightIndex;
        int pivot = intArray[pivotIndex];
        rightIndex -= 1;

        while (true) {
            while (intArray[leftIndex] < pivot) {
                leftIndex++;
            }

            while ((intArray[rightIndex] > pivot) && (rightIndex != 0)) {
                rightIndex--;
            }

            if (leftIndex > rightIndex) {
                break;
            }
            int temp = intArray[leftIndex];
            intArray[leftIndex] = intArray[rightIndex];
            intArray[rightIndex] = temp;
            leftIndex++;

        }
        intArray[pivotIndex] = intArray[leftIndex];
        intArray[leftIndex] = pivot;

        return leftIndex;
    }

    public void quickSort(int leftIndex, int rightIndex) {
        if ((rightIndex - leftIndex) <= 0) {
            return;
        }
        int pivotIndex = partition(leftIndex, rightIndex);
        quickSort(leftIndex, pivotIndex - 1);
        quickSort(pivotIndex + 1, rightIndex);
    }

    public void quickSort() {
        quickSort(0, intArray.length - 1);
    }
}
