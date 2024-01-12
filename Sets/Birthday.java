package Sets;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Birthday {
    
    public static void main(String[] args) {
        
        long average = 0L;
        long trials = 10_000_000;
        Random rand = new Random(); 

        for (int i = 0; i < trials; i++){
            
            Set<Integer> set = new HashSet<Integer> (); 
            while (set.size() < 365){
                set.add(rand.nextInt(365));
                average++;
            }

            if (i % 1_000_000 == 0){
                System.out.println("Progress: " + (i/Double.valueOf(trials) * 100) + "% at time: " + System.currentTimeMillis());
            }
        }
        System.out.println("It took " + average/Double.valueOf(trials) + " times on average.");
    }
}
