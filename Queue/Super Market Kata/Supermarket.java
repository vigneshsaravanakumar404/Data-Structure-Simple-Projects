import java.util.LinkedList;
import java.util.Queue;

public class Supermarket  {

    public static void main(String[] args) {
        System.out.println(solveSuperMarketQueue(new int[] {2,3,10}, 2));
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {

        // Variables
        Queue<Integer> queue = new LinkedList<Integer>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        int minCheckout = 0;
        int[] checkouts = new int[n];

        // Add customers to queue
        for (int i = 0; i < customers.length; i++) {
            queue.add(customers[i]);
        }
        
        // Send the Customer to the Checkout with the Least Time
        while (!queue.isEmpty()) {
            for (int i = 0; i < checkouts.length; i++) {
                if (checkouts[i] < min) {
                    min = checkouts[i];
                    minCheckout = i;
                }
            }
            checkouts[minCheckout] += queue.poll();
            min = Integer.MAX_VALUE;            
        }

        // Find the Checkout with the Longest Time
        for (int i = 0; i < checkouts.length; i++) {
            if (checkouts[i] > max) {
                max = checkouts[i];
            }
        }
        return max;
    }
}