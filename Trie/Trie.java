import java.util.HashMap;
import java.util.Map;

class Trie {

	private TrieNode root;

	Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie
	public void add(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			current.incrementCount();
		}
		current.setEndOfWord(true);
	}

	// Returns true if the word is in the trie
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

	// Returns the frequency of the word in the trie
	public Map<Character, Double> likelyNextCharsFrequency(String start) {
		TrieNode current = root;
		for (int i = 0; i < start.length(); i++) {
			TrieNode node = current.getChildren().get(start.charAt(i));
			if (node == null) {
				return new HashMap<>();
			}
			current = node;
		}
		Map<Character, Double> frequency = new HashMap<>();
		int total = current.getCount();
		for (Map.Entry<Character, TrieNode> entry : current.getChildren().entrySet()) {
			frequency.put(entry.getKey(), (double) entry.getValue().getCount() / total);
		}
		return frequency;
	}

	// Returns the most likely next character given the word
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
