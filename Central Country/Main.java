import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

class Main {

    // Variables
    private static final String data = "GEODATASOURCE-COUNTRY-BORDERS.CSV";
    private static Set<Country> countries = new HashSet<Country>();
    private static PriorityQueue<Country> rank = new PriorityQueue<Country>();
    private static int TOP = 15;

    public static void main(String[] args) {

        // Add All Countries
        try (BufferedReader br = new BufferedReader(new FileReader(data))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                String countryCode = values[0];
                String countryName = values[1];
                Country country = new Country(countryName, countryCode);

                if (countryCode.equals("country_code")) {
                    continue;
                }

                countries.add(country);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add depth 1 borders
        try (BufferedReader br = new BufferedReader(new FileReader(data))) {

            String line;
            int depth = 1;

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                if (values.length < 4) {
                    continue;
                }
                String countryName = values[1];
                String borderName = values[3];

                for (Country country : countries) {
                    if (country.getName().equals(countryName)) {
                        for (Country border : countries) {
                            if (border.getName().equals(borderName)) {
                                country.addBorder(border, depth);
                            }
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add other borders
        for (Country country : countries) {
            country.compute();
            rank.add(country);
        }

        // Print top 15
        System.out.println("C-Factor" + "\t\t\t" + "Country");
        if (rank.size() < TOP) {
            TOP = rank.size();
        }
        for (int i = 0; i < TOP; i++) {
            Country country = rank.poll();
            System.out.println(country);
        }
    }
}
