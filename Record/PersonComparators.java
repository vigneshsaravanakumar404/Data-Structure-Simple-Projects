import java.util.*;

public class PersonComparators {
    public static class NameComparator implements Comparator<Person> {

        public int compare(Person person1, Person person2) {
            return person1.name().compareTo(person2.name());
        }

    }

    public static class AgeComparator implements Comparator<Person> {

        public int compare(Person person1, Person person2) {
            Integer age1 = person1.age();
            Integer age2 = person2.age();
            return age1.compareTo(age2);
        }
    }

    public static class WageComparator implements Comparator<Person> {

        public int compare(Person person1, Person person2) {
            Double wage1 = person1.hourlyWage();
            Double wage2 = person2.hourlyWage();
            return wage1.compareTo(wage2);
        }
    }
}
