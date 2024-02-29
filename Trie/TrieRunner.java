public class TrieRunner {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Add words to the Trie
        trie.add("then");
        trie.add("them");
        trie.add("there");
        trie.add("theme");

        // Test contains method
        System.out.println("contains(\"them\") -> " + trie.contains("them")); // Should print true
        System.out.println("contains(\"the\") -> " + trie.contains("the")); // Should print false
        System.out.println("contains(\"this\") -> " + trie.contains("this")); // Should print false

        // Test mostLikelyNextChar method
        System.out.println("mostLikelyNextChar(\"the\") -> '" + trie.mostLikelyNextChar("the") + "'"); // Should print
        // 'm'
        System.out.println("mostLikelyNextChar(\"this\") -> '" + trie.mostLikelyNextChar("this") + "'"); // Should print
        // '_'
        System.out.println("mostLikelyNextChar(\"theme\") -> '" + trie.mostLikelyNextChar("theme") + "'"); // Should
        // print '_'
    }
}
