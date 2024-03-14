package algorithms.recursion.problems;

import java.util.Arrays;

public class TotalNumberOfCharactersInArrayOfStrings {
    // Problem:
    // Write a function that sums up all characters of the strings in an array (with recursion)
    // Eg: ["ab", "cd", "def", "ghij"] => 11
    public static void main(String[] args) {
        String [] strings = {"ab", "cd", "def", "ghij"};
        System.out.println(sumNoOfCharactersInAllStrings(strings));
    }

    public static int sumNoOfCharactersInAllStrings(String [] strings) {
        if(strings.length == 1) {                       // base case: if string array is of length 1
            return strings[0].toCharArray().length;     // return just the length of the char array of the first string
        }

        return strings[0].toCharArray().length + sumNoOfCharactersInAllStrings(Arrays.copyOfRange(strings, 1, strings.length)); // return the length of the char array of the first string in the array and recursive
        // call to sumNoOfCharactersInAllStrings but with array without first string
    }
}
