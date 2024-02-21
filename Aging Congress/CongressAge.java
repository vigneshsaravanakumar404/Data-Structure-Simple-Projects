import java.io.*;
import java.util.*;
public class CongressAge {

    private Scanner reader;
	private Set<Year> listOfYears;

    public static void main(String[] args) {
        CongressAge ca = new CongressAge();
        ca.listOfYears.forEach(y -> y.calculate());
		ca.listOfYears.forEach(y -> System.out.println(y));
	}
    
		
    public CongressAge() {
        reader = new Scanner(System.in);
		listOfYears = new TreeSet<Year>();

        try {
            BufferedReader input = new BufferedReader(new FileReader("data_aging_congress.csv"));
            input.readLine();
			String line = "";
			while ((line = input.readLine()) != null)
            {
                String[] data = line.split(",");
                String name = data[6] + " " + data[5];
				int year = Integer.parseInt(data[1].split("/")[2]);
				Double age = Double.parseDouble(data[12]);
                
				Iterator<Year> it = listOfYears.iterator();
				Year y = null;
				while (it.hasNext()) {
					y = it.next();
					if (y.getYear() == year) {
						y.addPerson(name, age);
						break;
					}
				}
				if (y == null){
					y = new Year(year);
					y.addPerson(name, age);
				}

            }

        } catch (IOException io) {
            System.err.println("File Error");
        }
    }

    // public void run() {
    //     int ans = 0;

    //     while (ans != -1) {

    //         System.out.println("\nWhich would you like to find:");

    //         System.out.println("1) Average age of congress member");
    //         System.out.println("2) Name of youngest congress member");
    //         System.out.println("3) Year with oldest average congress members");
    //         System.out.println("4) Name of median age congress member");
	// 		System.out.println("5) Year with the youngest average congress members");
    //         System.out.println("-1) Quit ");
    //         System.out.print("\nEnter your Choice => ");

    //         ans = reader.nextInt();

    //         switch (ans) {
    //             case -1:
    //                 break;
    //             case 1:
    //                 aveAge(getYear());
    //                 break;
    //             case 2:
    //                 youngest(getYear());
    //                 break;
    //             case 3:
    //                 yearWithOldestAverage();
    //                 break;
    //             case 4:
    //                 medianAgeName(getYear());
    //                 break;
    //                 // Add one more option that you think makes sense

    //             default:
    //                 System.out.println("Input not understood, try again");
    //         }
    //     }
    // }

    public int getYear() {
        int year = 0;
        do {
            System.out.print("\nEnter odd number year 1919 - 2023: ");
            year = reader.nextInt();
        } while (year < 1919 || year > 2023 || year % 2 == 0);
        return year;
    }


    public void aveAge(int year) {
        long startTime = System.currentTimeMillis();
        String line = "", text = "";

        try {
            BufferedReader input = new BufferedReader(new FileReader("data_aging_congress.csv"));
            input.readLine();
            while ((line = input.readLine()) != null)
                text += line + "\n";
        } catch (IOException io) {
            System.err.println("File Error");
        }

        // Find year

        String[] lines = text.split("\n");
        double ageTotal = 0;
        int yearCount = 0;
        for (String row: lines) {
            row = row.substring(row.indexOf(",") + 1); // remove everything before first comma
            int ci = row.indexOf(",");
            int yearInLine = Integer.parseInt(row.substring(ci - 4, ci));
            if (year == yearInLine) {
                yearCount++;
                row = row.substring(0, row.lastIndexOf(","));
                String ageStr = row.substring(row.lastIndexOf(",") + 1);
                ageTotal += Double.parseDouble(ageStr);
            }

        }

        System.out.println("Average age in " + year + " was " + (ageTotal / yearCount) + " years.");
        System.out.println("Result found in " + (System.currentTimeMillis() - startTime) / 1000.0 + " seconds");

    }

	// Find youngest at a certain year
    public void youngest(int year) {
        long startTime = System.currentTimeMillis();
        String line = "", text = "";

        try {
            BufferedReader input = new BufferedReader(new FileReader("data_aging_congress.csv"));
            input.readLine();
            while ((line = input.readLine()) != null)
                text += line + "\n";
        } catch (IOException io) {
            System.err.println("File Error");
        }

        // Find year

        String[] lines = text.split("\n");
        double minAge = 1000;
        String minAgeName = "";
        for (String row: lines) {
            row = row.substring(row.indexOf(",") + 1); // remove everything before first comma
            int ci = row.indexOf(",");
            int yearInLine = Integer.parseInt(row.substring(ci - 4, ci));
            if (year == yearInLine) {
                row = row.substring(0, row.lastIndexOf(","));
                String ageStr = row.substring(row.lastIndexOf(",") + 1);
                double age = Double.parseDouble(ageStr);
                if (age < minAge) {
                    minAge = age;
                    minAgeName = row.substring(row.indexOf("\"") + 1, row.lastIndexOf("\""));
                }
            }

        }

        System.out.println("Youngest congress member " + minAgeName + " age " + minAge + " years old.");
        System.out.println("Result found in " + (System.currentTimeMillis() - startTime) / 1000.0 + " seconds");

    }

	// Find year with oldest average age
    public void yearWithOldestAverage() {
		System.out.println("Stub method: Find the year with the oldest average age of congress person");
    }

	// Find median age and name
    public void medianAgeName(int year) {
        System.out.println("Stub method:  Print name and age of median congress person of given year");
    }

    // Add one more method that you think makes sense.


}
