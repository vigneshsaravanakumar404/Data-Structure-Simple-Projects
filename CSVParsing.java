import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        }
    }
}
