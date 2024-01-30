import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrimeFloor {

	private final Map<Integer, Integer> cache;

	public PrimeFloor() {
		this.cache = new HashMap<>();
	}

	public int get(int key) {
		if (cache.containsKey(key)) {
			System.out.println("Cache hit! Returning value from cache for key: " + key);
			return cache.get(key);
		} else {
			int value = calculateValue(key);
			cache.put(key, value);
			System.out.println("Cache miss! Calculated value for key: " + key);
			return value;
		}
	}

	private int calculateValue(int key) {
		while (!isPrime(key))
			key--;
		return key;
	}

	private boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false; // Found a factor, not a prime number
			}
		}
		return true; // No factors found, it's a prime number
	}


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		PrimeFloor pf = new PrimeFloor();
		FactorSets fs = new FactorSets();

		int num = 0;
		do {
			System.out.print("Enter a number (or -1 to quit): ");
			num = scan.nextInt();
			if (num != -1)
				System.out.println("Prime floor value ==> " + pf.get(num));
				System.out.println("Number of factors ==> " + fs.get(num));
		} while (num != -1);

	}

}
