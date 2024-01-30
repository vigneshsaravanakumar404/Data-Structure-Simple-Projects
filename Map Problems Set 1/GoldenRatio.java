import java.util.HashMap;
import java.util.Map;

public class GoldenRatio {
    
    public static void main(String[] args) {
        
        // Store in Array
        String golden = "61803398874989484820458683436563811772030917980576286213544862270526046281890244970720720418939113748475408807538689175212663386222353693179318006076672635";
        String[] goldenArray = golden.split("");
        
        // Create a Map of all the two digit combinations of numbers that occur after the decimal point
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < goldenArray.length - 1; i++) {
            String key = goldenArray[i] + goldenArray[i + 1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        // Total number of combinations
        System.out.print(map.size() + " 2-digit combinations, ");

        // Print Combinations that occurred more than 4 times
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 4) {
                System.out.print(entry.getKey() + " occurred " + entry.getValue() + " times, ");
            }
        }
    }
}
