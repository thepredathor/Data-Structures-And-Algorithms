
package algorithms.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;


public class AllAnagramsOfAGivenString {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Given a string return all anagrams of said string
    // Eg: "abc" => [abc, acb, bac, bca, cab, cba]
    // Eg: "abcd" => [abcd, abdc, acbd, acdb, adbc, adcb, bacd, badc, bcad, bcda, bdac, bdca, cabd, cadb, cbad, cbda, cdab, cdba, dabc, dacb, dbac, dbca, dcab, dcba]
    public static void main(String[] args) {
        String[] anagrams = getAllStringAnagrams("abc");
        System.out.println(Arrays.toString(anagrams));
        System.out.println(anagrams.length);
        String[] anagrams2 = getAllStringAnagrams("abcd");
        System.out.println(Arrays.toString(anagrams2));
        System.out.println(anagrams2.length);
    }

    public static String[] getAllStringAnagrams(String string) {
        if (string.length() == 1) {                         // if length of string is 1
            return string.split("");                  // return the string as array
        }

        ArrayList<String> anagrams = new ArrayList<>();     // container that will hold the anagrams
        String[] lettersInString = string.split("");  // split string by empty space to get all letter
        for (String s : lettersInString) {                  // iterate on all letters
            String stringWithoutCurrentString = string.replaceFirst(s, ""); // remove current letter from parameter string
            String[] subAnagrams = getAllStringAnagrams(stringWithoutCurrentString); // get all anagrams of the string without current letter
            for (String anagram : subAnagrams) {            // for each anagram resulted
                anagrams.add(s + anagram);                  // concatenate the letter to the anagram
            }
        }

        return anagrams.toArray(String[]::new);             // return anagram container as array
    }
}
