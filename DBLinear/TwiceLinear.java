package DBLinear;

import java.util.HashSet;
import java.util.PriorityQueue;

public class TwiceLinear {
    
    public static void main(String[] args) {
        System.out.println(dblLinear(10));
    }

    public static int f(int x) {
        return 2 * x + 1;
    }

    public static int g(int x){
        return 3 * x + 1;
    }

    public static int dblLinear (int n) {
        n++;
        if (n == 0) return 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(1);
        set.add(1);

        while (n > 0) {
            n--;
            int x = queue.poll();
            int y = f(x);
            int z = g(x);

            if (set.add(y)) {
                queue.add(y);
            }
            if (set.add(z)) {
                queue.add(z);
            }

            if (n == 0) return x;
        }

        return 0;
        
    }
}
