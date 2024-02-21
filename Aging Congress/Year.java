import java.util.Map;
import java.util.TreeMap;

public class Year implements Comparable{
    
    // Set Attributes
    private int year;
    private Map<Double, String> name_age;
    private double averageAge;
    private double medianAge;

    // Youngest and Oldest Attributes
    private String youngestName;
    private double youngestAge;
    private String oldestName;
    private double oldestAge;



    public Year(int year) {
        this.year = year;
        name_age = new TreeMap<Double, String>();
        averageAge = -1;
        medianAge = -1;

        youngestName = "";
        youngestAge = -1;
        oldestName = "";
        oldestAge = -1;
    }

    public void addPerson(String name, double age) {
        name_age.put(age, name);
    }

    public void calculate(){
        double total = 0;
        int count = 0;
        double[] ages = new double[name_age.size()];
        int i = 0;
        for (Map.Entry<Double, String> entry : name_age.entrySet()) {
            total += entry.getKey();
            ages[i] = entry.getKey();
            i++;
            count++;
        }
        averageAge = total / count;
        if (count % 2 == 0) {
            medianAge = (ages[count / 2] + ages[count / 2 - 1]) / 2;
        } else {
            medianAge = ages[count / 2];
        }
        
        // Youngest and Oldest
        youngestAge = ages[0];
        youngestName = name_age.get(ages[0]);
        oldestAge = ages[count - 1];
        oldestName = name_age.get(ages[count - 1]);
    }

    public double getAverageAge() {
        calculate();
        return averageAge;
    }

    public double getMedianAge() {
        calculate();
        return medianAge;
    }

    public String getYoungestName() {
        calculate();
        return youngestName;
    }

    public double getYoungestAge() {
        calculate();
        return youngestAge;
    }

    public String getOldestName() {
        calculate();
        return oldestName;
    }

    public double getOldestAge() {
        calculate();
        return oldestAge;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Object o) {
        Year y = (Year) o;
        if (this.getAverageAge() > y.getAverageAge()) {
            return 1;
        } else if (this.getAverageAge() < y.getAverageAge()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        String output = "";
        String statistics = "Year: " + year + "\n" + "Average Age: " + averageAge + "\n" + "Median Age: " + medianAge + "\n" + "Youngest: " + youngestName + " " + youngestAge + "\n" + "Oldest: " + oldestName + " " + oldestAge + "\n";
        String people = "";
        for (Map.Entry<Double, String> entry : name_age.entrySet()) {
            people += entry.getValue() + " " + entry.getKey() + "\n";
        }
        
        output += statistics + "\n" + people + "\n";

        return output;
    }
}
