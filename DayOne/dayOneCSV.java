import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class dayOneCSV {
    public static void main(String[] args) {

        // Part 1
        System.out.println("Part 1\n");
        int count = 0;

        try {
            File file = new File("dayOneCSVData.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                count++;
                if (count % 2 == 0) {
                    System.out.println(line + " is a bit odd");
                }
                if (count % 2 != 0) {
                    System.out.println(line + " is even tempered");
                }

            }
            br.close();
        } catch (IOException io) {
            System.err.println("File Error: " + io);
        }

        System.out.println("\n\n\n\n\nPart 2\n");

        // Part 2
        double average = 0;
        double[] scores = new double[10];

        try {
            File file = new File("dayOneCSVData2.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int count2 = 0;
            while ((line = br.readLine()) != null) {
                scores[count2] = Double.parseDouble(line);
                average += scores[count2];
                count2++;
            }
            br.close();

        } catch (IOException io) {
            System.err.println("File Error: " + io);
        }

        System.out.println("The average of the scores is: " + average / 10.0);
        for (int i = 0; i < scores.length; i++) {
            System.out.println("The difference between the average and " + scores[i] + " is: "
                    + (average / 10.0 - scores[i]));
        }
    }
}