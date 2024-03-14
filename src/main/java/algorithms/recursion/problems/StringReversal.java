package algorithms.recursion.problems;

public class StringReversal {

    // Problem:
    // Reverse string using recursion
    // Eg: "abcdef" => "fedcba"
    public static void main(String[] args) {
        System.out.println(reverseString("abcdef"));
        System.out.println(reverseString2("abcdef"));
    }

    public static String reverseString(String s) {
        if(s.length() == 1) {                                   // base case: if string length is 1 => overflow/out of bounds if otherwise
            return String.valueOf(s.charAt(s.length() - 1));    // return last element of string
        }

        return String.valueOf(s.charAt(s.length() - 1)) + reverseString(s.substring(0, s.length() - 1));    // concatenate the string at the end of string with recursive call of string from begin to end - 1
    }

    public static String reverseString2(String s) {             // same as "reverseString" but with return value changed around (recursive call first and first element)
        if(s.length() == 1) {                                   // base case: if string length is 1 => overflow/out of bounds if otherwise
            return String.valueOf(s.charAt(0));                 // return first element of string
        }

        return reverseString2(s.substring(1, s.length())) + String.valueOf(s.charAt(0));    // concatenate the result of recursive call of substring minus first element with the first element
    }
}
