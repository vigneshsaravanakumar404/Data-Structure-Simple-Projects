import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        // Variables
        int[] golfScores = { 72, 68, 75, 78, 80, 73, 71, 69, 74, 77, 82, 76, 72, 70, 79, 81, 75, 78, 72, 74, 76, 80, 73,
                77, 75 };
        int[] testData = { 1, 1, 1, 1, 0, 1 };
        

        // Test Method
        Map<Integer, Double> output = golfScoreFreqAnalysis(testData);
        for (Map.Entry<Integer, Double> entry : output.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    static Map<Integer, Double> golfScoreFreqAnalysis(int[] array) {

        // Variables
        int size = array.length;
        Map<Integer, Double> output = new HashMap<>();

        for (int i = 0; i < size; i++) {
            if (output.get(array[i]) == null) {
                output.put(array[i], 1.0 / size);
            } else {
                output.put(array[i], output.get(array[i]) + (1.0 / size));
            }
        }

        // Remove all keys with value less than 0.05 and convert to percent
        Iterator<Map.Entry<Integer, Double>> it = output.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Double> entry = it.next();
            if (entry.getValue() < 0.05) {
                it.remove();
            } else {
                entry.setValue(entry.getValue() * 100);
            }
        }

        return output;
    }
}
