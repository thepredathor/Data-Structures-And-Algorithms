package algorithms.searching;

public class QuickSelect {
    public static void main(String[] args) {
        int[] intArray = {0, 50, 20, 10, 60, 30};
        QuickSelect quickSelect = new QuickSelect(intArray);
        System.out.println(quickSelect.quickSelect(1));
    }
    public int[] intArray;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors
    //~ ----------------------------------------------------------------------------------------------------------------

    public QuickSelect(int[] intArray) {
        this.intArray = intArray;
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

    public int quickSelect(int nthLowestNumber, int leftIndex, int rightIndex) {
        if(rightIndex - leftIndex <= 0) {
            return intArray[leftIndex];
        }
        int pivotIndex = partition(leftIndex, rightIndex);

        if(nthLowestNumber > pivotIndex) {
            return quickSelect(nthLowestNumber, pivotIndex + 1, rightIndex);
        } else if(nthLowestNumber < pivotIndex) {
            return quickSelect(nthLowestNumber, leftIndex, pivotIndex - 1);
        } else {
            return intArray[pivotIndex];
        }
    }

    public int quickSelect(int nthLowestNumber) {
        return quickSelect(nthLowestNumber, 0, intArray.length - 1);
    }
}
