
package data_structures.map.problems;

import java.util.HashMap;
import java.util.Map;


public class MissingLetterInString {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Problem:
    // Find missing letter in a string that contains all letters of the alphabet except one
    // Eg: "the quick brown box jumps over a lazy dog" => "f" is missing
    public static void main(String[] args) {
        System.out.println(findMissingLetter("the quick brown box jumps over a lazy dog"));
    }

    public static String findMissingLetter(String string) {
        Map<String, Integer> alphabetHashMap = getAlphabetHashMap(); // get alphabet strings mapped to 0 occurrences

        for (char c : string.replace(" ", "").toCharArray()) {
            alphabetHashMap.computeIfPresent(String.valueOf(c), (key, value) -> ++value); // for the string in the alphabet map increase occurrences by 1
        }

        //J-
        return alphabetHashMap.entrySet().stream()      // find the string where occurrences are 0 => missing letter in the string
                .filter(entry -> entry.getValue() == 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        //J+
    }

    private static Map<String, Integer> getAlphabetHashMap() {
        HashMap<String, Integer> lettersOfTheAlphabet = new HashMap<>();
        lettersOfTheAlphabet.put("a", 0);
        lettersOfTheAlphabet.put("b", 0);
        lettersOfTheAlphabet.put("c", 0);
        lettersOfTheAlphabet.put("d", 0);
        lettersOfTheAlphabet.put("e", 0);
        lettersOfTheAlphabet.put("f", 0);
        lettersOfTheAlphabet.put("g", 0);
        lettersOfTheAlphabet.put("h", 0);
        lettersOfTheAlphabet.put("i", 0);
        lettersOfTheAlphabet.put("j", 0);
        lettersOfTheAlphabet.put("k", 0);
        lettersOfTheAlphabet.put("l", 0);
        lettersOfTheAlphabet.put("m", 0);
        lettersOfTheAlphabet.put("n", 0);
        lettersOfTheAlphabet.put("o", 0);
        lettersOfTheAlphabet.put("p", 0);
        lettersOfTheAlphabet.put("q", 0);
        lettersOfTheAlphabet.put("r", 0);
        lettersOfTheAlphabet.put("s", 0);
        lettersOfTheAlphabet.put("t", 0);
        lettersOfTheAlphabet.put("u", 0);
        lettersOfTheAlphabet.put("v", 0);
        lettersOfTheAlphabet.put("w", 0);
        lettersOfTheAlphabet.put("x", 0);
        lettersOfTheAlphabet.put("y", 0);
        lettersOfTheAlphabet.put("z", 0);

        return lettersOfTheAlphabet;
    }

}
