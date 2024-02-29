import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TrieRunner {
    public static void main(String[] args) {
        Trie trie = new Trie();

        // Load words from words.txt
        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                trie.add(line.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
