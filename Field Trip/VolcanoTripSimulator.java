import java.util.ArrayList;
import java.util.Stack;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VolcanoTripSimulator {

    private static int iterations = 10_000;

    public static void main(String[] args) {

        // Load students from Students.txt
        System.out.println("\nLoading students...\n\n");
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            for (String line : Files.readAllLines(Paths.get("Students.txt"))) {
                students.add(new Student(line, line, line, line));
            }
        } catch (Exception e) {
            System.out.println("Error loading students");
            System.exit(1);
        }

        // Create a stack of students
        Stack<Student> stack = new Stack<Student>();
        for (Student s : students) {
            stack.push(s);
        }

        // Run 10000 times
        int everyoneMadeIt = 0;
        for (int i = 0; i < iterations; i++) {

            boolean lavaBathTaken = false;
            for (int j = 0; j < stack.size(); j++) {

                Student s = stack.get(stack.size() - j - 1);

                if (lavaBathTaken) {
                    break;
                } else if (Math.random() < 0.1) {
                    s.lavaBaths();
                    lavaBathTaken = true;
                }
            }
            if (!lavaBathTaken) {
                everyoneMadeIt++;
            }
            lavaBathTaken = false;

        }

        // Print out the stack
        for (Student s : stack) {
            System.out.println(s.getName() + " --> " + "Lava Baths = " + s.getLavaBaths() + "("
                    + String.format("%.2f", (((double) s.getLavaBaths() / iterations)) * 100) + "%)");
        }
        System.out.println(everyoneMadeIt + " out of " + iterations + " made it everytime ("
                + String.format("%.2f", (((double) everyoneMadeIt / iterations)) * 100) + "%)");
    }
}
