import java.util.TreeMap;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bowling {

    public static void main(String[] args) {

        TreeMap<Integer, PriorityQueue<Bowler>> bowlersMap = new TreeMap<>();

        // Read the file and populate the map
        try (BufferedReader br = new BufferedReader(new FileReader("BowlingData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0] + " " + parts[1];
                int score = Integer.parseInt(parts[2]);

                bowlersMap.computeIfAbsent(score, k -> new PriorityQueue<>()).add(new Bowler(name, score));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the map
        for (Integer score : bowlersMap.keySet()) {

            PriorityQueue<Bowler> queue = bowlersMap.get(score);
            System.out.print(score + "=");

            // Print the bowlers
            while (!queue.isEmpty()) {
                Bowler bowler = queue.poll();
                System.out.print(bowler.getName());
                if (!queue.isEmpty()) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
