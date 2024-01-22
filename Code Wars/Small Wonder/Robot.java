import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Robot {

	public Set<String> wordBank = new HashSet<>(Arrays.asList("thank", "you", "for", "teaching", "me", "i", "already", "know", "the", "word", "do", "not", "understand", "input"));

	public String learnWord(String word) {

        // Check if word matches the regex [a-zA-Z]+ using regex pattern
        if (word.matches("[a-zA-Z]+")) {

            // Check if word is already in wordBank
            if (wordBank.add(word.toLowerCase())) {
                return "Thank you for teaching me " + word;
            } else {
                return "I already know the word " + word;
            }
        } else {
            return "I do not understand the input";
        }


		
	}

}