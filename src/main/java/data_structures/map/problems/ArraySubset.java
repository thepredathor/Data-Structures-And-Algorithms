
package data_structures.map.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.sun.jdi.BooleanValue;


public class ArraySubset {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Determine whether an array is a subset of another array
    // Eg: firstArray = [a,b,c,f,d], secondArray = [a,c,b] => secondArray is subset of first
    public static void main(String[] args) {
        String[] firstArray = { "a", "b", "c", "f", "d" };
        String[] subArray = { "a", "c", "b" };
        String[] subArray2 = { "a", "c", "h" };

        System.out.println(mapFastAnswer(firstArray, subArray));
        System.out.println(mapFastAnswer(firstArray, subArray2));
    }

    public static boolean slowAnswer(String[] firstArray, String[] secondArray) {
        //implementation with nested for loops searching one by one if one character from first array is present in second
        return true;
    }

    public static boolean mapFastAnswer(String[] firstArray, String[] secondArray) {
        //J-
        Map<String, Boolean> stringsToTrueMap = new HashMap<>();
        for(String s: firstArray) {
            stringsToTrueMap.put(s, true);
        }                                   // convert first array to hashmap of string keys and boolean true values
        //J+
        for (String s : secondArray) { // lookup each string from the second array in the map to see if present
            if (Boolean.TRUE != stringsToTrueMap.get(s)) { // if not present return false as second array is not subset of first
                return false;
            }
        }

        return true;
    }
}
