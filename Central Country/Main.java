import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

class Main {

    // Variables
    private static final String data = "GEODATASOURCE-COUNTRY-BORDERS.CSV";
    private static Set<Country> countries = new HashSet<Country>();

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
        int depth = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(data))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] values = line.split(",");
                if (values.length < 3) {
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

        for (Country country : countries) {
            country.calculateCentrality();
        }

        // Print countries sorted by centrality
        countries.stream().sorted((c1, c2) -> Double.compare(c2.Centrality, c1.Centrality)).forEach(System.out::println);
    }
}