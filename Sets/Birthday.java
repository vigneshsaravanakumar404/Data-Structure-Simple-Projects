package Sets;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class Birthday {
    
    public static void main(String[] args) {
        
        double average = 0.0;
        int trials = 100_000_000;
        Random rand = new Random(); 

        for (int i = 0; i < trials; i++){
            
            Set<Integer> set = new HashSet<Integer> (); 
            while (set.size() < 365){
                set.add(rand.nextInt(365));
                average++;
            }

            if (i % 100_000 == 0){
                System.out.println("Progress: " + String.valueOf((i/Double.valueOf(trials)) * 100) + "%");
            }
        }
        System.out.println("It took " + String.valueOf(average/trials) + " times on average.");
    }
}
