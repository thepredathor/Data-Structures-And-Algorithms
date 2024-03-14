package algorithms.recursion.problems;

public class CountNumberOfLetters {
    // Problem:
    // Count number of Xs in a given string
    // Eg: "axbxcxd" => 3
    public static void main(String[] args) {
        System.out.println(countXs("axbxcxdxx"));
    }

    public static int countXs(String s) {
        if(s.length() == 0) {               // base case: if string is empty
            return 0;                       // return 0
        }

        if (String.valueOf(s.charAt(0)).equalsIgnoreCase("x")) { // if first element is "x"
            return 1 + countXs(s.substring(1, s.length()));                 // add 1 + recursive call of substring from 1 to string length
        }

        return countXs(s.substring(1, s.length()));                         // else don't add 1 and just return substring from 1 to string length
    }
}
