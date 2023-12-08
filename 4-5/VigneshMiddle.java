import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(n)
 * 
 * The program reads the file once to populate a HashMap with the middle letters
 * and their frequency. At the same time, it also updates the result variable.
 * The HashMap has a constant lookup time, therefore, the time complexity is
 * influenced
 * only by the main loop, which is O(n), where n is the number of words in the
 * file.
 */
public class VigneshMiddle {

    public static void main(String[] args) {
        try {

            // Read the file
            BufferedReader br = new BufferedReader(new FileReader(new File("MiddleLetterWords.txt")));
            Map<Character, Integer> middleLetterCount = new HashMap<>();
            int result = 0;
            String line;

            // O(n) To loop through the file and sum the counts of the middle letters
            while ((line = br.readLine()) != null) {

                line = line.replaceAll("\\s+", "");
                char middleLetter = line.charAt(line.length() / 2);
                int newCount = middleLetterCount.getOrDefault(middleLetter, 0) + 1;
                middleLetterCount.put(middleLetter, newCount);

                // Check if this is the second occurrence of this middle letter
                if (newCount == 2) {
                    result += 2;
                } else if (newCount > 2) {
                    result++;
                }
            }

            System.out.println("Ans--> " + result); // Should print 4 for your example
            br.close();

        } catch (IOException io) {
            System.err.println("File Error: " + io);
        }
    }
}