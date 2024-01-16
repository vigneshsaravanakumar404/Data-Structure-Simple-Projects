package DBLinear;

import java.util.HashSet;
import java.util.Set;

public class Robot {
    private Set<String> vocabulary;

    public Robot() {
        vocabulary = new HashSet<>();

        learnWord("Thank");
        learnWord("you");
        learnWord("for");
        learnWord("teaching");
        learnWord("me");
        learnWord("I");
        learnWord("already");
        learnWord("know");
        learnWord("the");
        learnWord("word");
    }

    public String learnWord(String word) {
        if (!word.matches("^[a-zA-Z]+$")) {
            return "I do not understand the input";
        }

        word = word.toLowerCase();
        if (vocabulary.contains(word)) {
            return "I already know the word " + word;
        } else {
            vocabulary.add(word);
            return "Thank you for teaching me " + word;
        }
    }

}
