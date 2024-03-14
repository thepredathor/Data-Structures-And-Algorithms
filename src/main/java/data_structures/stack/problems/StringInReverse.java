
package data_structures.stack.problems;

import java.util.Arrays;
import java.util.Stack;


public class StringInReverse {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Reverse a string using stack
    // Eg: abcd => dcba
    public static void main(String[] args) {
        System.out.println(reverseString("abcde"));
        String[] split = "abcde".split("");
        System.out.println(Arrays.toString(split));
    }

    public static String reverseString(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : charArray) { // loop through characters
            stack.push(c); // push to stack each character read from left to right
        }

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = stack.pop(); // pop each character and put them back in the char array
        }

        return String.valueOf(charArray); // return string
    }
}
