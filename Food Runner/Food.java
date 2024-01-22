public class Food {
    private String name;
    private int calories;

    public Food(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return name + " : " + calories + " calories";
    }

    @Override
    // Note: This is a highly 'defensive' equals, that allows comparison with any object including null
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Food otherFood = (Food) o;

        if (calories != otherFood.calories) return false;
        return name != null ? name.equals(otherFood.name) : otherFood.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 17 * result + calories;  // Using 17 (primes help reduce collisions)
        return result;
    }
}