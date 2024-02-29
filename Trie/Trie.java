
/**
Code based on Source code from Baeldung
https://github.com/eugenp/tutorials/tree/master/data-structures

Edited by Chris Haver to make some of the implementation more familiar
to Data Structure Students and to add count attribute to TrieNode.
*/
import java.util.HashMap;
import java.util.Map;

class Trie {

  private TrieNode root;

  Trie() {
    root = new TrieNode(); // Note root has no
  }

  public void add(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
      current.incrementCount();
    }
    current.setEndOfWord(true);
  }

  public boolean contains(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      TrieNode node = current.getChildren().get(word.charAt(i));
      if (node == null) {
        return false;
      }
      current = node;
    }
    return current.isEndOfWord();
  }

  public String mostLikelyNextChar(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
      TrieNode node = current.getChildren().get(word.charAt(i));
      if (node == null) {
        return "_"; // Return '_' when no character is found
      }
      current = node;
    }
    int max = 0;
    char maxChar = '_'; // Set default to '_'
    for (Map.Entry<Character, TrieNode> entry : current.getChildren().entrySet()) {
      if (entry.getValue().getCount() > max) {
        max = entry.getValue().getCount();
        maxChar = entry.getKey();
      }
    }
    return Character.toString(maxChar);
  }

  /*********** INNER CLASS ********/
  class TrieNode {
    private final Map<Character, TrieNode> children;
    private boolean endOfWord;
    private int count;

    public TrieNode() {
      children = new HashMap<>();
      endOfWord = false;
      count = 1;
    }

    private Map<Character, TrieNode> getChildren() {
      return children;
    }

    private void incrementCount() {
      count++;
    }

    private int getCount() {
      return count;
    }

    private boolean isEndOfWord() {
      return endOfWord;
    }

    private void setEndOfWord(boolean endOfWord) {
      this.endOfWord = endOfWord;
    }

    public String toString() {
      return "(" + count + ")";
    }
  }
  /********* END INNER CLASS ************/
}
