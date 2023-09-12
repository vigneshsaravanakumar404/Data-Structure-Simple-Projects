import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        // Declarations
        ArrayList<Student> students = new ArrayList<Student>();
        String line = "";

        try {

            File file = new File("3AStudentData.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {

                students.add(
                        new Student(line.split(",")[1], line.split(",")[2], line.split(",")[3], line.split(",")[4]));

            }

            br.close();

        } catch (IOException io) {
            System.err.println("File Error: " + io);
        }

        // Testing
        System.out.println("The random student is: " + randomStudent(students));
        Quiz(students);

    }

    // Return Random Student
    static Student randomStudent(ArrayList<Student> students) {

        Random rand = new Random();
        return students.get(rand.nextInt(students.size() + 1));

    }

    // Quiz
    static void Quiz(ArrayList<Student> students) {

        System.out.println("\n\n");

        Scanner scanner = new Scanner(System.in);
        Student temp = randomStudent(students);

        System.out.println("Hello let's take a quiz: ");
        System.out.print("Who's favorite noun is \"" + temp.getNoun() + "\": ");
        String answer = scanner.nextLine();
        scanner.close();

        if (answer.equals(temp.getFirstName())) {
            System.out.println("\nTHAT IS CORRECT!");
        } else {
            System.out.println("\nWRONGGGGGGGGGG!");
        }

    }

    public static void getNounandSentance(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first and last name of who you want to stalk: ");

        String name = scanner.nextLine();

        for (Student e : students) {
            if (e.toString().equals(name)) {
                System.out.println("\nTheir word is " + e.getNoun() + "\nTheir sentance is " + e.getOneThing());
            }
        }
    }

    public static void searchByDataField(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter \"First\",\"Last\",\"Noun\", or \"Sentance\": ");

        String type = scanner.nextLine();
        if (type.equals("First")) {

            System.out.print("Enter first name of who you want to stalk: ");

            String name = scanner.nextLine();

            for (Student e : students) {
                if (e.getFirstName().equals(name)) {
                    System.out.println("\nTheir name is " + e.toString() + " and their word is " + e.getNoun()
                            + " and their sentance is " + e.getOneThing());
                }
            }

        }
        if (type.equals("Last")) {

            System.out.print("Enter last name of who you want to stalk: ");

            String name = scanner.nextLine();

            for (Student e : students) {
                if (e.getLastName().equals(name)) {
                    System.out.println("\nTheir name is " + e.toString() + " and their word is " + e.getNoun()
                            + " and their sentance is " + e.getOneThing());
                }
            }
        }
        if (type.equals("Noun")) {

            System.out.print("Enter noun of who you want to stalk: ");

            String name = scanner.nextLine();

            for (Student e : students) {
                if (e.getNoun().equals(name)) {
                    System.out.println("\nTheir name is " + e.toString() + " and their word is " + e.getNoun()
                            + " and their sentance is \"" + e.getOneThing() + "\"");
                }
            }
        }
        if (type.equals("Sentance")) {

            System.out.print("Enter sentance of who you want to stalk: ");

            String name = scanner.nextLine();

            for (Student e : students) {
                if (e.getOneThing().equals(name)) {
                    System.out.println("\nTheir name is " + e.toString() + " and their word is " + e.getNoun()
                            + " and their sentance is " + e.getOneThing());
                }
            }
        }

    }

    public static void alphabetize(ArrayList<Student> students) {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < students.size(); i++) {
            names.add(students.get(i).toString());
        }
        Collections.sort(names);
        ArrayList<Student> s = new ArrayList<Student>();
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < students.size(); j++) {
                if (names.get(j).equals(students.get(j).toString())) {
                    s.add(students.get(j));
                    students.remove(j);
                }
            }
        }
        students = s;
    }

    public static void createGroups(ArrayList<Student> students) {
        int[] n = new int[students.size()];
        for (int i = 0; i < students.size(); i++) {
            n[i] = i;
        }
        for (int i = 0; i < 9999; i++) {
            int x = (int) (Math.random() * students.size());
            int y = (int) (Math.random() * students.size());
            int temp = n[x];
            n[x] = n[y];
            n[y] = temp;
        }
        if (students.size() % 3 == 1) {
            for (int i = 0; i < students.size(); i++) {
                if (i % 3 == 0 && i < students.size() - 3) {
                    System.out.println("\nGroup " + (i / 3 + 1));
                } else if (i == students.size() - 2) {
                    System.out.println("\nGroup " + ((i + 2) / 3 + 1));
                }
                System.out.println(students.get(i));
            }
        } else {
            for (int i = 0; i < students.size(); i++) {
                if (i % 3 == 0) {
                    System.out.println("\nGroup " + (i / 3 + 1));
                }
                System.out.println(students.get(i));
            }
        }
    }

}
