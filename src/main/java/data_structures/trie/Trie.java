
package data_structures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Trie {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields 
    //~ ----------------------------------------------------------------------------------------------------------------

    public TrieNode root;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors 
    //~ ----------------------------------------------------------------------------------------------------------------

    public Trie() {
        this.root = new TrieNode();
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    public TrieNode search(String searchString) {
        TrieNode currentNode = root;
        String[] characters = searchString.split("");

        for (String character : characters) {
            if ((currentNode.charactersToChildrenMap != null) && (currentNode.charactersToChildrenMap.get(character) != null)) {
                currentNode = currentNode.charactersToChildrenMap.get(character);
            } else {
                return null;
            }
        }
        return currentNode;
    }

    public TrieNode insert(String searchString) {
        TrieNode currentNode = root;
        String[] characters = searchString.split("");

        for (String character : characters) {
            if (currentNode.charactersToChildrenMap == null) {
                currentNode.charactersToChildrenMap = new HashMap<>();
                currentNode.charactersToChildrenMap.put(character, new TrieNode());
            }
            currentNode = currentNode.charactersToChildrenMap.get(character);
        }

        currentNode.charactersToChildrenMap.put("*", null);

        return currentNode;
    }

    public String[] getAllWords(String word) {
        TrieNode finalLetterInWordNode = this.root;
        if (word.isEmpty()) {
            finalLetterInWordNode = search(word);
        }
        return getAllWords(finalLetterInWordNode, "", new ArrayList<>());
    }

    public String[] getAllWords(TrieNode trieNode, String wordToBeComposed, List<String> words) {
        if (trieNode == null) {
            return new String[] {};
        }

        for (Map.Entry<String, TrieNode> entry : trieNode.charactersToChildrenMap.entrySet()) {
            if (!"*".equals(entry.getKey())) {
                getAllWords(entry.getValue(), wordToBeComposed + entry.getKey(), words);
            } else {
                words.add(wordToBeComposed);
            }
        }

        return words.toArray(String[]::new);
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Nested Classes 
    //~ ----------------------------------------------------------------------------------------------------------------

    public static class TrieNode {
        public Map<String, TrieNode> charactersToChildrenMap;

        public TrieNode() {
            this.charactersToChildrenMap = new HashMap<>();
        }
    }
}
