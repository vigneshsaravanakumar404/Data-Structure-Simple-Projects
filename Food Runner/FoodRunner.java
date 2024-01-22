import java.util.Set;
import java.util.Iterator;

public class FoodRunner {

    private Set<Food> foods;

    public FoodRunner(Set<Food> foods) {
        this.foods = foods;
    }

    public void removeHighCalorieFoods(int maxCalories) {
        Iterator<Food> it = foods.iterator();
        while (it.hasNext()) {
            if (it.next().getCalories() >= maxCalories) {
                it.remove();
            }
        }
    }

    public void labelLowCalorieFoods(int maxCalories) {
        Iterator<Food> it = foods.iterator();
        while (it.hasNext()) {
            Food food = it.next();
            if (food.getCalories() <= maxCalories) {
                food.setName(food.getName() + " (Low-Cal)");
            }
        }
    }

    public int calculateTotalCalories() {
        int total = 0;
        Iterator<Food> it = foods.iterator();
        while (it.hasNext()) {
            total += it.next().getCalories();
        }
        return total;
    }

    @Override
    public String toString() {
        String result = "";
        Iterator<Food> it = foods.iterator();
        while (it.hasNext()) {
            result += it.next().toString() + "\n";
        }
        return result;
    }

}