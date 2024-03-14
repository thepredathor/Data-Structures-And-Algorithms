package algorithms.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class EvenNumbersInArray {
    // Problem:
    // Get array of even numbers in an array
    // Eg: [2,4,5,7,10,11] => [2,4,10]
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getEvenNumbersFromArray(new int[]{2,4,5,7,10,11})));
    }

    public static int[] getEvenNumbersFromArray(int [] array) {
        ArrayList<Integer> evenNumbers = new ArrayList<>(); // init a container for the even numbers

        if(array.length == 0) {                             // base case: if array empty
            return new int[]{};                             // return empty array
        }

        if(array[0] % 2 == 0) {                             // if first element even
            evenNumbers.add(array[0]);                      // add it to container
        }

        int[] evenNumbersFromArray = getEvenNumbersFromArray(Arrays.copyOfRange(array, 1, array.length));   // recursive call to function with array - first element

        for(int evenNumber : evenNumbersFromArray) {                                                             // iterate over the even elements of the sub arrays
            evenNumbers.add(evenNumber);                                                                         // add them to the container
        }

        return evenNumbers.stream().mapToInt(value -> value).toArray();                                          // return the container
    }
}