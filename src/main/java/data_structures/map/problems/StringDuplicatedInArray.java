
package data_structures.map.problems;

import java.util.HashMap;
import java.util.Map;


public class StringDuplicatedInArray {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Find the duplicate string in the strings array
    // Eg: [a, b, c, d, c, e, f] => "c" is the duplicate string
    public static void main(String[] args) {
        String[] strings = { "a", "b", "c", "d", "c", "e", "f" };
        System.out.println(firstDuplicateString(strings));
    }

    public static String firstDuplicateString(String[] strings) {
        HashMap<String, Integer> integerStringHashMap = new HashMap<>();
        for (String s : strings) {
            integerStringHashMap.putIfAbsent(s, 0); // if absent init map with occurrence 0 for the string
            integerStringHashMap.computeIfPresent(s, (key, value) -> ++value); // if present increase no of occurrences for that string
        }
        //J-
        return integerStringHashMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);                                            // filter strings in map that have no of occurrences bigger than 1 and find the first string
                                                                                // => string that is duplicated
        //J+
    }
}
