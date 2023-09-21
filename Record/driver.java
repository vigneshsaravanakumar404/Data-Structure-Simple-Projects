import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class driver {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<Person>();
        try {
            File file = new File("People.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Person person = new Person(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2]));
                people.add(person);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Unsorted List");
        PrintList(people);
        Collections.sort(people, new PersonComparators.NameComparator());

        System.out.println("Sorted by Name");
        PrintList(people);
        Collections.sort(people, new PersonComparators.AgeComparator());

        System.out.println("Sorted by Age");
        PrintList(people);
        Collections.sort(people, new PersonComparators.WageComparator());

        System.out.println("Sorted by Wage");
        PrintList(people);
    }

    public static void PrintList(ArrayList<Person> people) {
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }
    }
}