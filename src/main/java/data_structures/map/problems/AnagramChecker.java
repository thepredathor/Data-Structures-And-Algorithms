
package data_structures.map.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class AnagramChecker {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        String s1 = "rattles";
        String s2 = "startle";
        String s3 = "startles";
        String s4 = "startle";
        System.out.println(checkIfStringsAreAnagrams(s1, s2));
        System.out.println(checkIfStringsAreAnagrams(s3, s4));
    }

    public static boolean checkIfStringsAreAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<String, Integer> stringsToCountHashMap = new HashMap<>();

        String[] splitS1 = s1.split("");
        String[] splitS2 = s2.split("");

        for (String s : splitS1) {
            if (stringsToCountHashMap.get(s) != null) {
                stringsToCountHashMap.compute(s, (key, value) -> ++value);
            } else {
                stringsToCountHashMap.put(s, 1);
            }
        }

        for (String s : splitS2) {
            if (stringsToCountHashMap.get(s) != null) {
                stringsToCountHashMap.compute(s, (key, value) -> --value);
            } else {
                return false;
            }
        }

        //J-
        return stringsToCountHashMap.entrySet().stream()
                .allMatch(entry -> entry.getValue() == 0);
    }
}
