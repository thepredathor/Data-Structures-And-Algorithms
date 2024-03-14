
package data_structures.map.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class FirstNonDuplicatedString {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Find first non duplicated string in a given string
    // Eg: "minimum" => "n" is the first non duplicated string because "u" is the second in line
    public static void main(String[] args) {
        System.out.println(firstNonDuplicatedString("minimum"));
    }

    public static String firstNonDuplicatedString(String string) {
        HashMap<String, StringNoOfOccurenceToIndexPair> stringToClass = new HashMap<>();
        char[] charArray = string.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            String s = String.valueOf(charArray[i]);
            if (!stringToClass.containsKey(s)) { // if map does not contain the string put string associated with the pair of no of occurrences = 1 and its index
                stringToClass.put(String.valueOf(charArray[i]), new StringNoOfOccurenceToIndexPair(1, i));
            } else {
                stringToClass.get(s).index = i; // if map contains the string get pair and increase no of occurrences by 1 and modify its index
                stringToClass.get(s).noOfOccurences += 1;
            }
        }

        //J-
        return stringToClass.entrySet().stream()
                .filter(entry -> entry.getValue().noOfOccurences == 1)                                                  // filter map for no of occurrences bigger than 1
                .sorted(Comparator.comparingInt(entry -> entry.getValue().index))                                       // sort the map by the index of the string in the original array
                .map(Map.Entry::getKey)                                                                                 // find first occurrence of the string with no of occurrences = 1 and smallest index
                .findFirst()                                                                                            // => first non duplicated string in array
                .orElse(null);
        //J+
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Nested Classes 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static class StringNoOfOccurenceToIndexPair {
        public int noOfOccurences;
        public int index;

        public StringNoOfOccurenceToIndexPair(int noOfOccurences, int index) {
            this.noOfOccurences = noOfOccurences;
            this.index = index;
        }
    }
}
