import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    public boolean check(String sentence) {
        sentence = sentence.toLowerCase().replaceAll("[^a-zA-Z]", "");
        ;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        if (set.size() == 26) {
            return true;
        }
        return false;
    }
}