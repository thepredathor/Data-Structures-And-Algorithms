
package algorithms.recursion.problems;

import java.util.Arrays;


public class FirstIndexOfCharacterInString {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Given a string s with a character repeating, get the first index of that character assuming the character is always present
    // Eg: "abcdefghijklmnopqrstuvwxyz" for character 'x' => 23
    public static void main(String[] args) {
        System.out.println(getIndexOfCharacterXInString("abcdefghijklmnopqrstuvwxyz"));
    }

    public static int getIndexOfCharacterXInString(String s) {
        if (s.length() == 0) { // base case: if length of string is 0
            return 0; // return 0 as index
        }

        String[] splitString = s.split(""); // base case 2:
        if ("x".equalsIgnoreCase(splitString[0])) { // if first string in string param is 'x' then return 0 index
            return 0;
        }

        // return 1 + recursive call to method of string without first character
        return 1 + getIndexOfCharacterXInString(String.join("", Arrays.copyOfRange(splitString, 1, splitString.length))); // summing 1 for each character != 'x' until 'x' is found
    }
}
