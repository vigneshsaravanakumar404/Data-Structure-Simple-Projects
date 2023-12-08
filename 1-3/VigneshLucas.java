import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class VigneshLucas {

    public static void main(String[] args) {

        // Get input from file
        try {

            File file = new File("1-3\\lucas.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {

                // Print the Lucas Number for each line
                System.out.println(lucas(new BigInteger(line)));

            }
            br.close();

        } catch (IOException io) {
            System.err.println("File Error: " + io);
        }
    }

    // Iterative Lucas Number Generator using BigInteger
    static BigInteger lucas(BigInteger n) {
        BigInteger a = BigInteger.valueOf(2);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger c = BigInteger.valueOf(0);
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            c = a.add(b);
            a = b;
            b = c;
        }
        return c;
    }

}