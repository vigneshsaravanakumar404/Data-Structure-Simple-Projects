import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Get Poem From File
        String data = "";
        try {
            File myObj = new File("Poem.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + " ";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Get First Letters
        String[] words = data.toLowerCase().replace(",", "").replace(".", "").split(" ");
        String[] strings = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            strings[i] = words[i].substring(0, 1);
        }

        // Find Counts of each Letter
        Map<String, Integer> output = new HashMap<String, Integer>();
        for (int i = 0; i < strings.length; i++) {
            if (output.get(strings[i]) == null) {
                output.put(strings[i], 1);
            } else {
                output.put(strings[i], output.get(strings[i]) + 1);
            }
        }

        // Remove Even Ones
        Iterator<Map.Entry<String, Integer>> it1 = output.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry<String, Integer> entry = it1.next();
            if (entry.getValue() % 2 == 0) {
                it1.remove();
            }
        }

        // Print
        Iterator<Map.Entry<String, Integer>> it2 = output.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, Integer> entry = it2.next();
            System.out.println("" + entry.getKey() + "=" + entry.getValue());
        }

    }

}
