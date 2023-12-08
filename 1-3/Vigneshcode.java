import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Vigneshcode {
    public static void main(String[] args) {

        // Get input from
        try {

            File file = new File("1-3\\code.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            ArrayList<String> inputs = new ArrayList<String>();

            while ((line = br.readLine()) != null) {

                inputs.add(line);

            }

            br.close();
            System.out.println(code_breaker(inputs));

        } catch (IOException io) {
            System.err.println("File Error: " + io);
        }

    }

    static String code_breaker(ArrayList<String> inputs) {

        // Handing input
        String output = "";
        String answer;
        String guess;

        // Loop through inputs as sets of 2 elements
        for (int i = 0; i < inputs.size(); i += 2) {

            // Answer & Guess
            answer = inputs.get(i);
            output += "Code: " + answer + "\n";
            guess = inputs.get(i + 1);
            output += "Guess: " + guess + "\n";

            ArrayList<String> unmatched_in_answer = new ArrayList<String>();
            ArrayList<String> unmatched_in_guess = new ArrayList<String>();

            // Check for characters in the exact position
            int exact = 0;
            for (int j = 0; j < answer.length(); j++) {
                if (answer.charAt(j) == guess.charAt(j)) {
                    exact++;
                } else {
                    unmatched_in_answer.add(Character.toString(answer.charAt(j)));
                    unmatched_in_guess.add(Character.toString(guess.charAt(j)));
                }
            }

            // Check for characters in the wrong position
            int partial = 0;
            for (String unmatchedAnswer : new ArrayList<>(unmatched_in_answer)) {
                if (unmatched_in_guess.contains(unmatchedAnswer)) {
                    partial++;
                    unmatched_in_guess.remove(unmatchedAnswer);
                    unmatched_in_answer.remove(unmatchedAnswer);
                }
            }

            // Output
            output += "Color Correct - Correctly Placed: " + exact + "\n";
            output += "Color Correct - Incorrectly Placed: " + partial + "\n\n";

        }

        return output;
    }

}