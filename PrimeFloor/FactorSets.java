import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FactorSets {

    private final Map<Integer, String> cache;

    public FactorSets() {
        this.cache = new HashMap<>();
    }

    public String get(int key) {
        if (cache.containsKey(key)) {
            System.out.println("Cache hit! Returning value from cache for key: " + key);
            return cache.get(key);
        } else {
            String value = calculateFactors(key);
            cache.put(key, value);
            System.out.println("Cache miss! Calculated value for key: " + key);
            return value;
        }
    }

    private String calculateFactors(int number) {
        Set<Integer> factors = new TreeSet<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }
        return factors.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FactorSets fs = new FactorSets();

        int num = 0;
        do {
            System.out.print("Enter a number (or -1 to quit): ");
            num = scan.nextInt();
            if (num != -1)
                System.out.println("Positive Factors ==> " + fs.get(num));
        } while (num != -1);
    }
}
