import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
    Set<Food> foods = new HashSet<>();
    foods.add(new Food("Apple", 120));
    foods.add(new Food("Banana", 140));
    foods.add(new Food("Cake", 350));
    foods.add(new Food("Fries", 500));
    foods.add(new Food("Pizza", 360));
    foods.add(new Food("Chips", 180));
    foods.add(new Food("Burger", 600));
    foods.add(new Food("Pasta", 500));
    foods.add(new Food("Yogurt", 80));
    FoodRunner fr = new FoodRunner(foods);
    System.out.println("Original Food List:");
    System.out.println(fr);
    System.out.println("\nTotal cals = "+fr.calculateTotalCalories());
    fr.removeHighCalorieFoods(400);
    fr.labelLowCalorieFoods(140);
    System.out.println("\nAfter removing high calorie foods (400 or more)");
    System.out.println("and labeling low calorie foods (140 or less)");
    System.out.println(fr);

}

}
