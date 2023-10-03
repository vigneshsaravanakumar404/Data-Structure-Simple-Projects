import java.io.*;

public class CSVParsing {
    public static void main(String[] args) {

        try {
            File file = new File("dayOneCSVData.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println(values[0] + " is a bit odd");
                System.out.println(values[1] + " is even tempered");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
