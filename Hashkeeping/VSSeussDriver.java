import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VSSeussDriver {

    public static void main(String[] args) {

        // Open GreenEggsAndHam.txt and store it in a String
        String book = "";
        File file = new File("GreenEggsAndHam.txt");
        try (Scanner inputFile = new Scanner(file)) {
            while (inputFile.hasNext()) {
                book += inputFile.nextLine() + " ";
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        book.replace("\n", " ").replace("\r", " ");

        // Store each word in VSHashKeeper
        VSHashKeeper<String> hashKeeper = new VSHashKeeper<String>(100);
        String[] words = book.split(" ");
        for (String word : words) {
            hashKeeper.add(word);
        }
        System.out.println(hashKeeper.size() + " words in the book.");

        // Print hashKeeper with each word on a new line
        for (int i = 0; i < hashKeeper.table.length; i++) {
            if (hashKeeper.table[i] != null && hashKeeper.table[i] != hashKeeper.TOMB_STONE) {
                System.out.println("\"" + hashKeeper.table[i] + "\"");
            }
        }

    }
}
