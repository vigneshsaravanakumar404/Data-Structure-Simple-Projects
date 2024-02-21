import java.util.HashMap;

public class CongressPerson {

    private HashMap<Integer, Double> yearStarted_ageAtYer;
    private String name;
    private boolean isSenator;

    public CongressPerson(String name, boolean isSenator) {
        this.name = name;
        this.isSenator = isSenator;
        yearStarted_ageAtYer = new HashMap<Integer, Double>();
    }

    public void addYear(int year, double age) {
        yearStarted_ageAtYer.put(year, age);
        if (isSenator) {
            for (int i = 0; i < 5; i++) {
                yearStarted_ageAtYer.put(year + i, age + i);
            }
        } else {
            for (int i = 0; i < 2; i++) {
                yearStarted_ageAtYer.put(year + i, age + i);
            }
        }
    }

    public String getName() {
        return name;
    }

    public double getAgeAtYearinOffice(int year) {
        if (yearStarted_ageAtYer.containsKey(year)) {
            return yearStarted_ageAtYer.get(year);
        } else {
            return -1.0;
        }
    }
}


// CongressPerson: Year/Age
// Year: Age/Name
    // Average
    // Median