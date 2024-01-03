public class Main {

     public static void main(String[] args) {
          long number = 1;
          int day = 1;
          while (number < Long.MAX_VALUE){
               number *= 1.0/(day * day);
               day += 1;
               System.out.println("Day " + day + " : " + number);
          }
     }
}